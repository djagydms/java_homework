package game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Board extends JFrame{
    
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;
	int count = 1;
	int size = 3;
	JLabel label;
	ArrayList<JButton> Buttons;
    String[][] map;

	public Board() {
		
		JPanel buttonPanel = new JPanel();
		JPanel buttonPanel2 = new JPanel();
		GridLayout board = new GridLayout(3,3);
		buttonPanel.setLayout(board);
		add(buttonPanel, BorderLayout.CENTER);
		add(buttonPanel2, BorderLayout.SOUTH);

		setTitle("TicTacToe Game!");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

		map = new String[size][size];
		Buttons = new ArrayList<JButton>();
        
    	for(int i = 0 ; i< 3; i++) {
			for(int j = 0 ; j< 3; j++) {
				addButton(buttonPanel,i+"."+j,new ActionListener() {
					public void actionPerformed(ActionEvent event) { placePlayer(event);}
					
				});
			}
		}
    	label = new JLabel("");
    	Buttons.get(4).add(label);
    	label.setVisible(false);
    	
    	for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                map[row][col] = ".";
            }
        }
        
    	
    	JButton button1 = new JButton("재시작");
    	button1.addActionListener (new ActionListener() { public void actionPerformed(ActionEvent event) {init();}});
    	JButton button2 = new JButton("종료");
    	button2.addActionListener (new ActionListener() { public void actionPerformed(ActionEvent event) {System.exit(0);}});
		
    	buttonPanel2.add(button1);
    	buttonPanel2.add(button2);
	}
	
	public void init() {
		count = 1;
		int k = 0;
		label.setVisible(false);
		
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                map[row][col] = ".";
            }
        }
        
        while(k<9) {
        	for(int i = 0 ; i< 3; i++) {
     			for(int j = 0 ; j< 3; j++) {
     				JButton btn = Buttons.get(k);
     				btn.setText(i+"."+j);
     				btn.setEnabled(true);
     				btn.setBackground(new Color(153,153,255));
     				k++;
     			}
     		}
        }
	}

	public void addButton(Container cont, String title, ActionListener listener) {
		JButton button = new JButton(title);
		cont.add(button);
		button.addActionListener(listener);
		button.setBackground(new Color(153,153,255));
		Buttons.add(button);
	}
	
	public void placePlayer(ActionEvent event) {

		int x=0;

		
		while(x==0) {
	
			if(count ==1) {
				JButton clicked = (JButton)event.getSource();
				String text = clicked.getText();
				String[] place = text.split("\\.");
				int p1 = Integer.parseInt(place[0]);
				int p2 = Integer.parseInt(place[1]);
				if(p1>=0&&p2>=0) {
					if(p1<=size&&p2<=size) {
						if(map[p1][p2].equals(".")) {
							map[p1][p2]="x"; 
							clicked.setText("X");
							clicked.setBackground(new Color(255,0,0));
							clicked.setEnabled(false);
							count =2; x=2;
							check();
						}
						else {System.out.println("retry");} 
					}
					else{
						System.out.println("retry");
						}
					}
				else {
					System.out.println("retry");
				}
			}
			else if(count ==2) {
				JButton clicked = (JButton)event.getSource();
				String text = clicked.getText();
				String[] place = text.split("\\.");
				int p3 = Integer.parseInt(place[0]);
				int p4 = Integer.parseInt(place[1]);
				if(p3>=0&&p4>=0) {
					if(p3<=size&&p4<=size) {
						if(map[p3][p4].equals(".")) {
							map[p3][p4]="o"; 
							clicked.setText("O");
							clicked.setBackground(new Color(0,255,0));
							clicked.setEnabled(false);
							count =1; x=2;
							check();
						}
						else {System.out.println("retry");} }
					
					else {System.out.println("retry");}
			}else{System.out.println("retry");}
				}
		}
			
	}
	public void finish(String s){
		label.setText(s);
		label.setVisible(true);
		for(JButton j : Buttons) {
			j.setEnabled(false);
		}
	}
	
	public void check() {
		
			if(map[0][0].equals(map[0][1])&&map[0][0].equals(map[0][2])) {
				if(map[0][0].equals("x")) {
					finish("X win");
					
				}else if(map[0][0].equals("o")){
					finish("O win");
					
				}
			}
			if(map[1][0].equals(map[1][1])&&map[1][0].equals(map[1][2])) {
				if(map[1][0].equals("x")) {
					finish("X win");
					
				}else if(map[1][0].equals("o")){
					finish("O win");;
					
				}
			}
			if(map[2][0].equals(map[2][1])&&map[2][0].equals(map[2][2])) {
				if(map[2][0].equals("x")) {
					finish("X win");
					
				}else if(map[2][0].equals("o")){
					finish("O win");
					
				}
			}
			if(map[0][0].equals(map[1][0])&&map[0][0].equals(map[2][0])) {
				if(map[0][0].equals("x")) {
					finish("X win");
					
				}else if(map[0][0].equals("o")){
					finish("O win");;
					
				}
			}
			if(map[0][1].equals(map[1][1])&&map[0][1].equals(map[2][1])) {
				if(map[0][1].equals("x")) {
					finish("X win");
					
				}else if(map[0][1].equals("o")){
					finish("O win");
					
				}
			}
			if(map[0][2].equals(map[1][2])&&map[0][2].equals(map[2][2])) {
				if(map[0][2].equals("x")) {
					finish("X win");
					
				}else if(map[0][2].equals("o")){
					finish("O win");
					
				}
			}
			if(map[0][0].equals(map[1][1])&&map[0][0].equals(map[2][2])) {
				if(map[0][0].equals("x")) {
					finish("X win");
					
				}else if(map[0][0].equals("o")) {
					finish("O win");
					
				}
			}
			if(map[0][2].equals(map[1][1])&&map[0][2].equals(map[2][0])) {
				if(map[0][2].equals("x")) {
					finish("X win");
					
				}else if(map[0][2].equals("o")){
					finish("O win");
					
				}
			}
				
	}
}

