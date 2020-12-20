package homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SchoolManager {
	private List<School> schools = new ArrayList<>() ;

	public School findSchool(String schoolName) {
		
		for(School school : schools) {
			if(Objects.equals(school.getName(), schoolName) ) {
				return school;
			}
		}
		return null;
	}

	public School createSchool(String schoolName) {
		School newSchool = new School(schoolName);
		schools.add(newSchool);
		return newSchool;
	}

	public ArrayList<Student> findStudent(String studentName, int schoolYear) {
		ArrayList<Student> find = new ArrayList<>();
		
		for(School school : schools) {
			for(Student student : school.getStudents()) {
				if(Objects.equals(student.getName(),studentName)&& student.getYear() == schoolYear ) {
					find.add(student);
				}
			}
		}
		return find;
	}

	public void removeAllSchools() {
		schools.clear();
	}
	
	public String toString() {	
		String msg = "Total School Count: "+schools.size()+"\n";
		for(School school : schools) {
			msg += "School Name: "+ school.getName() + "Student Count: "+school.getStudents().size()+"\n";
			for(Student student : school.getStudents()) {
				msg += "[Name: " + student.getName() + ", School: "+ school.getName() +", " + student.getYear() + "ÇÐ³â ]\n";
			}

		}
		return msg ;
	}



}
