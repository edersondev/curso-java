package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class Exerc8 {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			infoConta();	
		} catch (InputMismatchException e) {
			System.out.println("Valor invalido.");
		} catch (DomainException e) {
			System.out.println("Erro de Saque: " + e.getMessage());
//			e.printStackTrace();
		}
	}
	
	public static void infoConta() {
		System.out.println("Entre com os dados da conta:");
		System.out.print("Número: ");
		Integer numero = sc.nextInt();
		
		System.out.print("Titular da conta: ");
		sc.nextLine();
		String titular = sc.nextLine();
		
		System.out.print("Saldo inicial: ");
		Double saldo = sc.nextDouble();
		
		System.out.print("Limite de saque: ");
		Double limiteSaque = sc.nextDouble();
		
		Conta conta = new Conta(numero, titular, saldo, limiteSaque);
		
		System.out.println();
		
		System.out.print("Informe o valor de saque: ");
		Double saque = sc.nextDouble();
		conta.sacar(saque);
		
		System.out.print("Novo valor de saldo: " + String.format("%.2f", conta.getSaldo()));
		
		sc.close();
	}

}
