package homework6;

import java.util.ArrayList;
import java.util.Scanner;


enum OperationKind {ADD,FIND,CLEAR,LIST,QUIT,INVALID}

public class SchoolManagerTest {
	private static Scanner scanner = new Scanner(System.in);
	private static SchoolManager schoolManager = new SchoolManager() ;
	
	public static void main(String[] args) {
		while ( true ) {
			final OperationKind op = getOperation();
			// process for QUIT, INVALID
			if ( op == OperationKind.QUIT ) {
				System.out.println("Bye") ;
				break;
			}
			if ( op == OperationKind.INVALID ) {
				System.out.println("Invalid Operation!") ;
				continue ;
			}
			switch ( op ) {
			case ADD : {
				Student newStudent = createStudent() ;
				System.out.println(newStudent) ;
				break ;
			}
			case FIND: 
				findStudent() ; break ;
			case CLEAR:
				schoolManager.removeAllSchools() ; break ;
			case LIST: 
				System.out.println(schoolManager) ; break ;
			default:
				break;
			}
		}
	}
	
	private static OperationKind getOperation() {
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

	private static Student createStudent() {
		
		final String schoolName = scanner.next() ;
		final String studentName = scanner.next() ;
		final int schoolYear = scanner.nextInt() ;
		
		School theSchool = schoolManager.findSchool(schoolName) ;
		
		if ( theSchool == null ) theSchool = schoolManager.createSchool(schoolName) ;
		
		
		final Student newStudent = new Student(theSchool, studentName, schoolYear) ;
		theSchool.addStudent(newStudent) ;
		
		return newStudent ;
	}

	private static void findStudent() {
		final String studentName = scanner.next();
		final int schoolYear = scanner.nextInt();
		final ArrayList<Student> foundStudents = schoolManager.findStudent(studentName, schoolYear) ;
		
		if ( foundStudents.size() > 0 ) {
			System.out.println(foundStudents.size() + " found") ;
			for ( Student s : foundStudents ) System.out.println(s) ;
		}
		else
			System.out.println("No Student Found with name " +
				studentName + " and year " + schoolYear) ;
	}
}
