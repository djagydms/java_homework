package game;

import javax.swing.JFrame;

public class TicTacToe {

  public static void main(String[] args) {
	  JFrame frame = new Board();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
  }
}