package entities;

public class Employee {
	
	private int id;
	private String name;
	private double salary;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void getInfo() {
		System.out.println(getId() + ", " + getName() + ", " + getSalary());
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void increaseSalary(double percentage) {
		double newSalary = (getSalary() * (percentage / 100)) + getSalary();
		this.salary = newSalary;
	}

}
