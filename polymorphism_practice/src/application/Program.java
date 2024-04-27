package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Contributor;
import entities.Individual;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contributor> contributors = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i=1; i<= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			
			if(type == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpanses = sc.nextDouble();
				
				contributors.add(new Individual(name, anualIncome, healthExpanses));
			} else if (type == 'c') {
				System.out.print("Number of employees: ");
				Integer numEmployees = sc.nextInt();
				
				contributors.add(new Company(name, anualIncome, numEmployees));
			}	
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		Double sum = 0.0;
		
		for (Contributor c : contributors) {
			System.out.println(c);
			
			sum += c.impostoPago();
		}
		
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();
	}

}
