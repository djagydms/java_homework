package homework5;

public class Student {
	private String name ;
	private int year ;

	public Student(String name, int year) {
		assert name != null;
		assert year >=1 && year <=4;
		
		this.name = name;
		this.year = year;
	}
	
	public String toString() {	
		String msg = "[" + this.name + ", " + this.year + "ÇĞ³â ]";
		return msg ;
	}
	
	@Override public boolean equals(Object o) {
        if (!(o instanceof Student))
        	return false;
        Student temp = (Student) o;
        return name.equals(temp.name) && year == temp.year;
        
    }
	@Override
	public int hashCode() {

		final int prime = 31;
		int hashCode = 1;

		hashCode = prime * hashCode + ((name == null) ? 0 : name.hashCode());
		hashCode = prime * hashCode + year;

		return hashCode;
	}
	// other methods including constructor,
	// toString(), equals(), hashcode()
}
