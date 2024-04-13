package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int employeeRegistriesNnumber = sc.nextInt();
		
		List<Employee> employeesList = new ArrayList<>();
		
		for(int i = 1; i <= employeeRegistriesNnumber; i ++) {
			System.out.printf("\nEmployee #" + i + ":\n");
			Employee employee = new Employee();
			System.out.print("Id: ");
			employee.setId(sc.nextInt());
			System.out.print("Name: ");
			sc.nextLine();
			employee.setName(sc.nextLine());
			System.out.print("Salary: ");
			employee.setSalary(sc.nextDouble());
			
			employeesList.add(employee);
			
		}
		
		System.out.printf("\nEnter the employee id that will have salary increase : ");
		int employeeId = sc.nextInt();
		
		Employee emp = employeesList.stream().filter(x -> x.getId() == employeeId).findFirst().orElse(null);
		
		if (emp != null) {
			System.out.print("Enter the percentage: ");
			emp.increaseSalary(sc.nextDouble());
		} else {
			System.out.println("This id does not exist!");
		}
		
		System.out.printf("\nList of employees:\n");
		
		for (Employee x : employeesList) {
			x.getInfo();
		}
		
		
		
		sc.close();
	}

}
