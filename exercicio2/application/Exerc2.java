package application;

import java.util.Scanner;

import entity.Rent;

public class Exerc2 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int qtd_rents;
		
		System.out.print("Quantos quarto serão alugados?");
		qtd_rents = sc.nextInt();
		
		Rent[] vect_rent = new Rent[10];
		
		for(int i=0;i < qtd_rents; i++) {
			sc.nextLine();
			System.out.println("Aluguel #" + (i + 1) );
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.next();
			System.out.print("Room: ");
			int room = sc.nextInt();
			vect_rent[room] = new Rent(nome, email);
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Quartos ocupados: ");
		for(int i = 0; i < vect_rent.length; i++) {
			if(vect_rent[i] != null) {
				System.out.println(i + ": " + vect_rent[i]);
			}
		}
		
		sc.close();
	}

}
