package homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RectangleManager {
	private List<Rectangle> rectangles = new ArrayList<>() ;
	private Scanner scannerObject ;

	public RectangleManager(Scanner scannerObject) {
		this.scannerObject = scannerObject;
	}

	public static void main(String[] args) {
		Scanner scannerObject = new Scanner(System.in) ;
		RectangleManager manager = new RectangleManager(scannerObject) ;
		while ( true ) {
			System.out.println("Enter a command: [create width height, zoom id ratio or quit]") ;
			final String command = scannerObject.next() ;
			try{
				if ( command.equalsIgnoreCase("create")) { manager.create() ; }
				else if ( command.equalsIgnoreCase("zoom")) { manager.zoom() ; }
				else if ( command.equalsIgnoreCase("showAll")) { manager.showAll() ; }
				else if ( command.equalsIgnoreCase("quit")) { System.out.println("Bye") ; break ; }
				
			}catch(InvalidRectangleException e) {
				System.out.printf("사각형의 넓이와 높이는 양수이어야 합니다. %d %d \n",e.getWidth(), e.getHeight());
			}catch(java.util.InputMismatchException e) {
				System.out.printf("입력된 인자의 형식이 맞지 않습니다. \n");
			}catch(java.lang.IndexOutOfBoundsException e) {
				System.out.printf("존재하지 않는 배열의 원소를 접근했습니다. "+ e +"\n");
			}
		}
		scannerObject.close();
	}

	private void showAll() {
		for(Rectangle r : rectangles) {
			System.out.println(r);
		}
	}

	private void zoom(){
		final int x = scannerObject.nextInt();
		final int y = scannerObject.nextInt();
		Rectangle r = rectangles.get(x);
		System.out.println("Before: " + r);
		r.setWidth(r.getWidth()*y);
		r.setHeight(r.getHeight()*y);
		System.out.println("After: " + r);
	}

	private void create() throws InvalidRectangleException{
		
		final int x = scannerObject.nextInt();
		final int y = scannerObject.nextInt();
		if(x<=0 || y<=0) throw new InvalidRectangleException(x,y);
		Rectangle r = new Rectangle(x,y);
		rectangles.add(r);
		System.out.println(r + " is added at "+ (rectangles.size()-1));
	}	
}
