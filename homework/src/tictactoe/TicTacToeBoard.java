package tictactoe;
import java.util.*;
public class TicTacToeBoard extends Board {
	int count;
	public TicTacToeBoard(int size){
		super(size);
		this.count=1;
		
	}
	
	public void print() {
		System.out.println("¡°Tic Tac Toe Game\n");
		super.print();
	}
	public void run() {
		for(int i=0; i<9; i++) {
			placePlayer();
			print();
			if(map[0][0].equals(map[0][1])&&map[0][0].equals(map[0][2])) {
				if(map[0][0].equals("x")) {
					System.out.println("x win");
					break;
				}else if(map[0][0].equals("o")){
					System.out.println("y win");
					break;
				}
			}
			if(map[1][0].equals(map[1][1])&&map[1][0].equals(map[1][2])) {
				if(map[1][0].equals("x")) {
					System.out.println("x win");
					break;
				}else if(map[1][0].equals("o")){
					System.out.println("y win");
					break;
				}
			}
			if(map[2][0].equals(map[2][1])&&map[2][0].equals(map[2][2])) {
				if(map[2][0].equals("x")) {
					System.out.println("x win");
					break;
				}else if(map[2][0].equals("o")){
					System.out.println("y win");
					break;
				}
			}
			if(map[0][0].equals(map[1][0])&&map[0][0].equals(map[2][0])) {
				if(map[0][0].equals("x")) {
					System.out.println("x win");
					break;
				}else if(map[0][0].equals("o")){
					System.out.println("y win");
					break;
				}
			}
			if(map[0][1].equals(map[1][1])&&map[0][1].equals(map[2][1])) {
				if(map[0][1].equals("x")) {
					System.out.println("x win");
					break;
				}else if(map[0][1].equals("o")){
					System.out.println("y win");
					break;
				}
			}
			if(map[0][2].equals(map[1][2])&&map[0][2].equals(map[2][2])) {
				if(map[0][2].equals("x")) {
					System.out.println("x win");
					break;
				}else if(map[0][2].equals("o")){
					System.out.println("y win");
					break;
				}
			}
			if(map[0][0].equals(map[1][1])&&map[0][0].equals(map[2][2])) {
				if(map[0][0].equals("x")) {
					System.out.println("x win");
					break;
				}else if(map[0][0].equals("o")) {
					System.out.println("y win");
					break;
				}
			}
			if(map[0][2].equals(map[1][1])&&map[0][2].equals(map[2][0])) {
				if(map[0][2].equals("x")) {
					System.out.println("x win");
					break;
				}else if(map[0][2].equals("o")){
					System.out.println("y win");
					break;
				}
			}
			
			if(i==8) {
				System.out.println("tie");
				break;
			}
		
		}
		
		
	}
	public void placePlayer() {
		Scanner scan = new Scanner(System.in);
		int x=0;
		
		
		while(x==0) {
	
			if(count ==1) {
				System.out.println("p1,p2:");
				int p1 = scan.nextInt();
				int p2 = scan.nextInt();
				if(p1>=0&&p2>=0) {
					if(p1<=size&&p2<=size) {
						if(map[p1][p2].equals(".")) {map[p1][p2]="x"; count =2; x=2;}
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
				System.out.println("p3,p4:");
				int p3 = scan.nextInt();
				int p4 = scan.nextInt();
				if(p3>=0&&p4>=0) {
					if(p3<=size&&p4<=size) {
						if(map[p3][p4].equals(".")) {
							map[p3][p4]="o"; count =1; x=2;}
						else {System.out.println("retry");} }
					
					else {System.out.println("retry");}
			}else{System.out.println("retry");}
				}
		}
			
	}
}
