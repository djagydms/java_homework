package homework13;

import java.awt.BorderLayout;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EchoServer {

	public static void main(String[] args) {
		JFrame frame = new JFrame("EchoServer");
		frame.setVisible(true);
		frame.setSize(600, 500);
		
		JTextArea  text = new JTextArea(8,40);
		JScrollPane scroll = new JScrollPane(text);
		frame.add(scroll, BorderLayout.CENTER);
		
		try {
			ServerSocket s = new ServerSocket(6003);

			while(true){
				Socket incoming = s.accept();
				InetAddress clientAddress = incoming.getInetAddress();
				text.append("Connected from "+ clientAddress+"\n");
				Runnable r = new ThreadEchoHandler(incoming, text);
				Thread t = new Thread(r);
				t.start();
			}
		}
		catch(IOException e) {e.printStackTrace();}
	}
}

class ThreadEchoHandler implements Runnable {

	private Socket incoming;
	private JTextArea text;
	public ThreadEchoHandler(Socket i, JTextArea t) {incoming = i; text = t;}
	
	@Override
	public void run() {
		try {
			try {
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true);
				boolean done = false;
				while(!done & in.hasNextLine()) {
					String line = in.nextLine();
					if(line.trim().equals("disconnect")) {
						text.append("Disconnected\n");
						out.println("Disconnected");
					} 
					else {
						text.append("Read: "+line+"\n");
						out.println("Hi! "+ line);
						text.append(String.format("Write: Hi! %s\n", line));
						if(line.trim().equals("quit")) done = true;
					}
				}
				in.close();
			}
			finally {incoming.close();}
		}
		catch(IOException e) {e.printStackTrace();}
	}
}
