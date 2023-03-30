package ui;

import java.util.Map;
import java.util.Scanner;

import student.Student;
import student.StudentDatabase;

public class MainMenu {
	private static Scanner scanner = new Scanner(System.in);
	private static StudentDatabase studentDB = new StudentDatabase();
	public static void main(String[] args) {
		int choice = 0;
		while (choice!= 6) {
			System.out.println("STUDENT MANAGEMENT SYSTEM");
			System.out.println("--------------");
			System.out.println("1. New Registration");
			System.out.println("2. Display Student Data");
			System.out.println("3. Display Student StudentDatabase");
			System.out.println("4. Remove Student Data");
			System.out.println("5. Clear Database");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				newRegistration();
				break;
			case 2:
				displayStudentData();
				break;
			case 3:
				displayStudentDatabase();
				break;
			case 4:
				removeStudentData();
				break;
			case 5:
				clearStudentDatabase();
				break;
			case 6: 
				System.out.println("Exiting Application....");
				break;
			default:
				System.out.println("Wrong Choice... Try Again...");
				break;
			}
		}
	}
	
	public static void newRegistration() {
		System.out.print("Enter name: ");
		String name = scanner.next();
		System.out.print("Enter age: ");
		int age = scanner.nextInt();
		System.out.print("Enter marks: ");
		float marks = scanner.nextFloat();
		System.out.print("Enter grade: ");
		String grade = scanner.next();
		if(studentDB.addNewStudent(name, age, marks, grade)) {
			System.out.println("Student Registered Successfully!!!");
		}
		else {
			System.out.println("Student already Exists..");
		}
	}
	
	public static void displayStudentData() {
		System.out.print("Enter Student Name: ");
		String name = scanner.next();
		try {
			Student studentData = studentDB.getStudentData(name);
			System.out.println("Student Details");
			System.out.println("---------------");
			System.out.println("Name: " + studentData.getName());
			System.out.println("Age: " + studentData.getAge());
			System.out.println("Marks: " + studentData.getMarks());
			System.out.println("Grade: " + studentData.getGrade());
		}
		catch (Exception e) {
			System.out.println("Student Not Found!!!!");
		}
	}
	
	public static void displayStudentDatabase() {
		System.out.println("STUDENT DATABASE");
		System.out.println("--------------------");
		Map<String, Student> studentData = studentDB.getDatabase();
		if(studentData.size() == 0) {
			System.out.println("NO DATA ");
		}
		else {
			studentData.forEach((k, v) -> {
				System.out.print("Name: " + v.getName());
				System.out.print("\tAge: " + v.getAge());
				System.out.print("\tMarks: " + v.getMarks());
				System.out.println("\tGrade: " + v.getGrade());
			});
		}
	}
	
	public static void removeStudentData() {
		System.out.print("Enter Student name: ");
		String name = scanner.next();
		if(studentDB.removeStudent(name)) {
			System.out.println("Removed Succesfully...");
		}
		else {
			System.out.println("No Student Found!!!");
		}
	}
	
	public static void clearStudentDatabase() {
		studentDB.clearDatabase();
		System.out.println("Student Database Cleared Successfully...");
	}
}
