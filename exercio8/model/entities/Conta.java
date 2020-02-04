package model.entities;

import model.exceptions.DomainException;

public class Conta {
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limitSaque;
	
	public Conta() {}
	
	public Conta(Integer numero, String titular, Double saldo, Double limitSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limitSaque = limitSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimitSaque() {
		return limitSaque;
	}

	public void setLimitSaque(Double limitSaque) {
		this.limitSaque = limitSaque;
	}
	
	public void depositar(Double valor) {
		this.saldo += valor;
	}
	
	public void sacar(Double valor) {
		if(valor > this.getLimitSaque()) {
			throw new DomainException("O valor excede o limite de saque.");
		}
		if(valor > this.getSaldo()) {
			throw new DomainException("Saldo insuficiente.");
		}
		this.saldo -= valor;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", limitSaque=" + limitSaque
				+ "]";
	}
	
	
}
