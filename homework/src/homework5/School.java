package homework5;

public class School {
	private String name ;
	private int limit ;
	
	private Student[] students ;
	private int studentCount ;

	public School(String s_name,int num) {
		this.name = s_name;
		this.limit = num;
		this.studentCount = 0;
		this.students = new Student[num];
	}
	
	public String toString() {	
		String msg = "School Name: " + name + " Student Count: " + studentCount + "\n" ;
		
		for ( int i = 0 ; i < studentCount ; i ++ ) {
			msg += students[i] + "\n" ;
		}
		return msg ;
	}

	public void addStudent(Student newStudent) {
		if(studentCount<100) {
			students[studentCount] = newStudent;
			studentCount++;

		}
	}

	public void removeAllStudent() {
		Student[] newstudents = new Student[this.limit];
		students = newstudents;  
		studentCount = 0;
	}

	public Student findStudent(String studentName, int schoolYear) {
		Student temp = new Student(studentName, schoolYear);
		for(int i =0 ; i < studentCount ; i++) {
			if(students[i].equals(temp)) {return students[i];}
		}
		
		return null;
	}
	
	@Override public boolean equals(Object o) {
        if (!(o instanceof School))
        	return false;
        School temp = (School) o;
        return name.equals(temp.name) && limit == temp.limit;
        
    }
	@Override
	public int hashCode() {

		//return Objects.hash(name,year);
		final int prime = 31;
		int hashCode = 1;

		hashCode = prime * hashCode + ((name == null) ? 0 : name.hashCode());
		hashCode = prime * hashCode + limit;

		return hashCode;
	}

	// other methods including constructor, equals(), hashCode()
}

