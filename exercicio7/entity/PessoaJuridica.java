package entity;

public class PessoaJuridica extends Contribuinte {

	private Integer numeroFuncionarios;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public Double calcularImposto() {
		Double porcentagem = (getNumeroFuncionarios() > 10 ? 0.14 : 0.16);
		return getRendaAnual() * porcentagem;
	}

}
