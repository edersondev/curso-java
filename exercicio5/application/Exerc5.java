package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entity.Client;
import entity.Order;
import entity.OrderItem;
import entity.Product;
import enums.OrderStatus;

public class Exerc5 {
	
	private static Scanner sc;

	public static void main(String[] args) throws ParseException {
		
		sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Informe os dados do cliente:");
		
		System.out.print("Nome: ");
		String nameClient = sc.nextLine();
		
		System.out.print("Email:");
		String email = sc.next();
		
		System.out.print("Data de nascimento (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(nameClient, email, birthDate);
		
		System.out.println("Informe dados do pedido:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("Quantos itens o pedido possui: ");
		Integer n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Informe os dados do item #" + i + ":");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			
			System.out.print("Preço do produto: ");
			Double price = sc.nextDouble();
			
			System.out.print("Quantidade: ");
			Integer quantity = sc.nextInt();
			
			Product product = new Product(productName, price);
			
			OrderItem item = new OrderItem(quantity, price, product);
			
			order.addItem(item);
		}
		
		System.out.println();
		
		System.out.println("Resumo do pedido:");
		
		System.out.print(order);
		
		sc.close();

	}

}
