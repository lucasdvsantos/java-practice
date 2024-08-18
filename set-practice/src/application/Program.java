package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Student;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Student> alexStudents = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int aQuantity = sc.nextInt();
		for ( int i = 1; i <= aQuantity; i++ ) {
			
			int studentUid = sc.nextInt();
			
			alexStudents.add(new Student(studentUid));
		}
		
		System.out.print("How many students for course B? ");
		int bQuantity = sc.nextInt();
		for ( int i = 1; i <= bQuantity; i++ ) {
			
			int studentUid = sc.nextInt();
			
			alexStudents.add(new Student(studentUid));
		}
		
		System.out.print("How many students for course C? ");
		int cQuantity = sc.nextInt();
		for ( int i = 1; i <= cQuantity; i++ ) {
			
			int studentUid = sc.nextInt();
			
			alexStudents.add(new Student(studentUid));
		}
		
		System.out.println("Total students: " + alexStudents.size());
		
		sc.close();

	}

}
