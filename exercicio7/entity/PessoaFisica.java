package entity;

public class PessoaFisica extends Contribuinte {
	
	private Double gastoSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}
	
	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public Double calcularImposto() {
		Double porcentagem = ( getRendaAnual() < 20000.0 ? 0.15 : 0.25 );
		return (getRendaAnual() * porcentagem) - (getGastoSaude() * 0.5);
	}
}
