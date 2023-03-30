package student;

public class Student {
	private String name;
	private int age;
	private float marks;
	private String grade;
	
	public Student(String name, int age, float marks, String grade) {
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public float getMarks() {
		return marks;
	}
	
	public String getGrade() {
		return grade;
	}
}
