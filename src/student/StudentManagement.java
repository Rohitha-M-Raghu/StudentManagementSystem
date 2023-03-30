package student;

import java.util.Map;

public interface StudentManagement {
	public boolean addNewStudent(String name, int age, float marks, String grade);
	public Student getStudentData(String name);
	public Map<String, Student> getDatabase();
	public boolean removeStudent(String name);
	public void clearDatabase();
}
