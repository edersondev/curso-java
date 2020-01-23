package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Contribuinte;
import entity.PessoaFisica;
import entity.PessoaJuridica;

public class Exerc7 {
	
	private static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<>();
		
		System.out.print("Informe o número de contribuintes: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Dados do contribuinte #" + i);
			
			System.out.print("Individual ou empresa (i/e)? ");
			char tipo = sc.next().charAt(0);
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Renda anual: ");
			Double rendaAnual = sc.nextDouble();
			
			if(tipo == 'i') {
				System.out.print("Gastos com saúde: ");
				Double gastoSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
			} else {
				System.out.print("Número de funcionários: ");
				Integer numeroFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
			}
		}
		
		System.out.println();
		System.out.println("Impostos a serem pagos:");
		
		Double totalImposto = 0.0;
		for(Contribuinte item : list) {
			totalImposto += item.calcularImposto();
			System.out.println(item);
		}
		
		System.out.println();
		System.out.print("Total de impostos: $ " + String.format("%.2f", totalImposto));
		
		sc.close();
	}
}
