package application;

import java.util.ArrayList;
import java.util.Scanner;
import entity.Empregado;

public class Exerc3 {

	private static Scanner sc;
	private static ArrayList<Empregado> lista;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Quantos funcionário serão registrados? ");
		Integer funcionarios = sc.nextInt();
		System.out.println();
		
		lista = new ArrayList<Empregado>();
		
		for(int i = 0; i < funcionarios; i++) {
			sc.nextLine();
			System.out.println("Funcionario #" + (i+1) + ":");
			
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Salário: ");
			Double salario = sc.nextDouble();
			
			Boolean checar = checarIdFuncionario(id);
			if(checar) {
				Empregado objEmpregado = new Empregado(id,nome,salario);
				lista.add(objEmpregado);
			}
			System.out.println();
		}
		
		aumentarSalario();
		
		System.out.println("Lista de funcionários:");
		for(Empregado obj : lista) {
			System.out.println(obj);
		}
		
		sc.close();
	}
	
	public static Boolean checarIdFuncionario(Integer id) {
		Empregado objFuncionario = lista.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
		if(objFuncionario != null) {
			System.out.println();
			System.out.println("O ID " + id + " já existe");
			return false;
		}
		return true;
	}
	
	public static void aumentarSalario() {
		System.out.print("Informe o ID do funcionário que terá aumento: ");
		Integer id = sc.nextInt();
		Empregado objFunc = lista.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
		if(objFunc != null) {
			System.out.print("Informe a porcentagem: ");
			Double porcentagem = sc.nextDouble();
			objFunc.aumentarSalario(porcentagem);
			System.out.println();
		} else {
			System.out.println("O ID " + id + " não existe.");
			System.out.println();
		}
	}

}
