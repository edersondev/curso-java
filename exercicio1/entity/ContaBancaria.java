package entity;

public class ContaBancaria {
	private int numero;
	private String titular;
	private double saldo;
	
	public ContaBancaria(int numero, String titular) {
		this.numero = numero;
		this.titular = titular;
	}
	public int getNumero() {
		return numero;
	}
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void sacar(double valor) {
		this.saldo -= valor + 5;
	}
	
	@Override
	public String toString() {
		return "Conta " + numero + ", " +
				"Titular: " + titular + ", " +
				"Saldo: R$ " + String.format("%.2f", saldo);
	}
}
