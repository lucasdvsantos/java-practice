package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Worker w1 = new Worker();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfIncome = new SimpleDateFormat("MM/yyyy");
		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		w1.setDepartment(new Department(sc.nextLine()));
		System.out.println("Enter worker data");
		System.out.print("Name: ");
		w1.setName(sc.nextLine());
		System.out.print("Level: ");
		w1.setLevel(WorkerLevel.valueOf(sc.nextLine()));
		System.out.print("Base Salary: ");
		w1.setBaseSalary(sc.nextDouble());
		System.out.print("How many contracts to this worker? ");
		int contractsNum = sc.nextInt();
		
		for (int i = 1; i <= contractsNum; i++) {
			System.out.println("Enter contract #" + i + " data:");
			HourContract c = new HourContract();
			sc.nextLine();
			System.out.print("Date (DD/MM/YYYY): ");
			c.setDate(sdf.parse(sc.nextLine()));
			System.out.print("Value per hour: ");
			c.setValuePerHour(sc.nextDouble());
			System.out.print("Duration (hours): ");
			c.setHours(sc.nextInt());
			
			w1.addContract(c);
		}
		
		System.out.println();
		sc.nextLine();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String incomeDate = sc.nextLine();
		cal.setTime(sdfIncome.parse(incomeDate));
		System.out.println("Name: " + w1.getName());
		System.out.println("Department: " + w1.getDepartment().getName());
		System.out.println("Income for " + incomeDate + ": " + w1.income(cal.get(Calendar.YEAR), 1 + cal.get(Calendar.MONTH)));
		
		sc.close();
	}

}
