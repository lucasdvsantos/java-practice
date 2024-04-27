package entities;

public abstract class Contributor {

	private String nome;
	private Double rendaAnual;
	
	public Contributor() {
	}

	public Contributor(String nome, Double rendaAnual) {
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRendaAnual() {
		return rendaAnual;
	}

	public void setRenda_anual(Double rendaAnual) {
		this.rendaAnual = rendaAnual;
	}
	
	public abstract Double impostoPago();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome + ": ");
		sb.append("$ " + String.format("%.2f", impostoPago()));
		
		return sb.toString();
	}
	
	
}
