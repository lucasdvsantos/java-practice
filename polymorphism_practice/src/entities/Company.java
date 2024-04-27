package entities;

public class Company extends Contributor{

	private Integer qtt_employees;
	
	public Company() {
		super();
	}

	public Company(String nome, Double rendaAnual, Integer qtt_employees) {
		super(nome, rendaAnual);
		this.qtt_employees = qtt_employees;
	}

	public Integer getQtt_employees() {
		return qtt_employees;
	}

	public void setQtt_employees(Integer qtt_employees) {
		this.qtt_employees = qtt_employees;
	}

	@Override
	public Double impostoPago() {
		Double tax = 0.0;
		if (qtt_employees <= 10) {
			tax = super.getRendaAnual() * 0.16;
		} else {
			tax = super.getRendaAnual() * 0.14;
		}
		
		return tax;
	}

}
