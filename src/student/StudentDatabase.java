package student;

import java.util.Map;
import java.util.TreeMap;

public class StudentDatabase implements StudentManagement{
	public TreeMap<String, Student> studentDatabase = new TreeMap<>();
	
	@Override
	public boolean addNewStudent(String name, int age, float marks, String grade) {
		if(studentDatabase.containsKey(name)) {
			return false;
		}
		else {
			studentDatabase.put(name, new Student(name, age, marks, grade));
			return true;
		}
	}
	
	@Override
	public Student getStudentData(String name) {
		return studentDatabase.get(name);
	}
	
	@Override
	public Map<String, Student> getDatabase(){
		return studentDatabase;
	}

	@Override
	public boolean removeStudent(String name) {
		if(studentDatabase.containsKey(name)) {
			studentDatabase.remove(name);
			return true;
		}
		else {
			return false;
		}
		
		
	}

	@Override
	public void clearDatabase() {
		studentDatabase.clear();
		
	}
	
	
}
