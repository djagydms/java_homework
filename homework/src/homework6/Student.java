package homework6;

public class Student {
	private final String name ;
	private int year ;
	private final School theSchool ;


	public Student ( School theSchool, String name, int year) {
		this.name = name;
		this.theSchool = theSchool;
		this.year = year;
	}


	public int getYear() {
		return year;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {	
		String msg = "[Name: " + this.name + ", School: "+ this.theSchool +", " + this.year + "ÇÐ³â ]";
		return msg ;
	}



}
