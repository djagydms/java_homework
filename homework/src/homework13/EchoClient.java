package homework13;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoClient {
	static Socket s = new Socket();
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("EchoClient");
		frame.setVisible(true);
		frame.setSize(600, 500);
		
		JTextArea  text = new JTextArea(8,40);
		JScrollPane scroll = new JScrollPane(text);
		frame.add(scroll, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		frame.add(panel,BorderLayout.SOUTH);

		
		addButton(panel,"Connect",new ActionListener() {public void actionPerformed(ActionEvent event) {
			try{
				s = new Socket("127.0.0.1",6003);
			//	InetSocketAddress addr = new InetSocketAddress("127.0.0.1",6000);
			//	s.connect(addr);
				text.append("Try to connect "+ s.getInetAddress()+"\n");
				text.append("Connection Established \n" );

			}catch(IOException e){e.printStackTrace();};
		
		}});
		
		addButton(panel,"DisConnect",new ActionListener() {public void actionPerformed(ActionEvent event) {
			try {
				
				text.append(sendMsg("disconnect"));
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}});		
		
		JTextField inputtext = new JTextField("hello World", 15);
		panel.add(inputtext);

		addButton(panel,"Send",new ActionListener() {public void actionPerformed(ActionEvent event) {
			text.append(String.format("Send: %s\n", inputtext.getText()));
			text.append(String.format("Receive: %s\n", sendMsg(inputtext.getText())));
		}});					

		addButton(panel,"Clear",new ActionListener() {public void actionPerformed(ActionEvent event) {
			text.setText(null);
		}});
		
		addButton(panel,"Quit",new ActionListener() {public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}});			
		
	}
	public static String sendMsg( String text) {
		
		try{
			InputStream inStream = s.getInputStream();
			Scanner in = new Scanner(inStream);
			OutputStream outStream = s.getOutputStream();
			PrintWriter out = new PrintWriter(outStream,true);

			out.println(text);
			if(in.hasNextLine()) {
				return in.nextLine();
			}
		}catch(IOException e) {e.printStackTrace();}
		return "error";
	}
	
	public static void addButton(Container container, String name, ActionListener listener) {
		JButton button = new JButton(name);
		container.add(button);
		button.addActionListener(listener);
	}
	

}
