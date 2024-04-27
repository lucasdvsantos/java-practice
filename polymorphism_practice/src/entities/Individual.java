package entities;

public class Individual extends Contributor{

	private Double gastosSaude;
	
	public Individual() {
		super();
	}

	public Individual(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double impostoPago() {
		Double tax = 0.0;
		if (super.getRendaAnual() < 20000.00) {
			tax = super.getRendaAnual() * 0.15;
		} else {
			tax = super.getRendaAnual() * 0.25;
		}
		
		if (gastosSaude > 0.0) {
			tax -= gastosSaude * 0.5;
		}
		
		return tax;
	}

}
