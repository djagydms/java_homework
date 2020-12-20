package homework6;

import java.util.ArrayList;
import java.util.List;

public class School {
	private final String name ;

	private List<Student> students = new ArrayList<>() ;

	public School(final String name) { 
		this.name = name ; 

	}

	public void addStudent(Student newStudent) {
		students.add(newStudent);

		
	}
	public String getName() {
		return name;
	}
	public List<Student> getStudents(){
		return students;
	}

	public String toString() {	
		String msg = name;
		return msg ;
	}


}
