package application;

import java.util.Scanner;

import entity.ContaBancaria;

public class Programa {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		System.out.print("Informe o número da conta: ");
		int numeroConta = sc.nextInt();
		
		System.out.print("Informe o nome do titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		
		System.out.print("Deseja realizar um depósito inicial (s/n)? ");
		char temDeposito = sc.next().charAt(0);
		
		ContaBancaria cb = new ContaBancaria(numeroConta, titular);
		
		if(temDeposito == 's') {
			System.out.print("Informe o valor do depósito inicial: ");
			cb.depositar(sc.nextDouble());			
		}
		
		System.out.println();
		
		System.out.println("Dados da conta:");
		System.out.println(cb);
		
		System.out.println();
		
		System.out.print("Informe um valor para depósito: ");
		cb.depositar(sc.nextDouble());
		
		System.out.println("Dados da conta atualizados:");
		System.out.println(cb);
		
		System.out.println();
		
		System.out.print("Informe um valor para saque: ");
		cb.sacar(sc.nextDouble());
		
		System.out.println("Dados da conta atualizados:");
		System.out.print(cb);
		
		sc.close();
	}

}
