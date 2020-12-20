package homework8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

enum OperationKind {ADDL,ADDC,SORTA,SORTD,LIST,CLEAR,QUIT,INVALID}
enum SortKind {ASCENDING,DESCENDING}

public class SortInterfaceTest {

	private static Scanner scanner = new Scanner(System.in);
	private static List<MyComparable> comparableList = new ArrayList<>() ;

	public static void main(String[] args) {
		while ( true ) {
			final OperationKind op = getOperation(scanner) ;
			if ( op == OperationKind.QUIT ) {
				System.out.println("Bye") ;
				break;
			}
			if ( op == OperationKind.INVALID ) {
				System.out.println("Invalid Operation!") ;
				continue ;
			}
			switch ( op ) {
			case ADDL : {
				final Line newLine = createLine(scanner) ;
				comparableList.add(newLine);
				System.out.println(newLine) ;
				break ;
			}
			case ADDC : {
				final Circle newCircle = createCircle(scanner) ;
				comparableList.add(newCircle);
				System.out.println(newCircle) ;
				break ;
			}
			case SORTA:
				sortList(comparableList, SortKind.ASCENDING) ;
				break ;
			case SORTD:
				sortList(comparableList, SortKind.DESCENDING) ;
				break ;
			case CLEAR:
				comparableList.clear() ;
				break ;
			case LIST: 
				System.out.println(comparableList) ;
				break ;
			default: break;
			}
		}
	}
	private static void sortList(List<MyComparable> comparableList, SortKind kind) {
		
		
		if(kind == SortKind.ASCENDING) {
			comparableList.sort(new Comparator<MyComparable>() {
				@Override
				public int compare(MyComparable o1, MyComparable o2) {
					return o1.compareTo(o2);
				}
			});
		}
		else if(kind == SortKind.DESCENDING) {
			comparableList.sort(new Comparator<MyComparable>() {
				@Override
				public int compare(MyComparable o1, MyComparable o2) {
					return o2.compareTo(o1);
				}
			});
		}
	}
	private static Circle createCircle(Scanner scanner) {
		final int x = scanner.nextInt() ;
		final int y = scanner.nextInt() ;
		final int radius = scanner.nextInt() ;
		
		Circle newC = new Circle(x,y,radius);
		return newC;
	}
	private static Line createLine(Scanner scanner) {
		final int x1 = scanner.nextInt() ;
		final int y1 = scanner.nextInt() ;
		final int x2 = scanner.nextInt() ;
		final int y2 = scanner.nextInt() ;
		
		Line newL = new Line(x1,y1,x2,y2);	
		return newL;
	}
	
	private static OperationKind getOperation(final Scanner scanner) {
		
		System.out.print("Enter Operation String! ");
		final String input = scanner.next().trim();
		OperationKind op;
		try{
			op = OperationKind.valueOf(input.toUpperCase());
		}
		catch(Exception e) {
			op = OperationKind.INVALID;
		}
		return op;
	}
}


