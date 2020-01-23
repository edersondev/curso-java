package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.ImportedProduct;
import entity.Product1;
import entity.UsedProduct;

public class Exerc6 {

	private static Scanner sc;
	private static SimpleDateFormat sdf;
	
	public static void main(String[] args) throws ParseException {
		sc = new Scanner(System.in);
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product1> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		Integer n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			switch(type) {
				case 'c':
					list.add(new Product1(name,price));
				break;
				
				case 'u':
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date manufactureDate = sdf.parse(sc.next());
					list.add(new UsedProduct(name,price,manufactureDate));
				break;
				
				default:
					System.out.print("Customs fee: ");
					Double customsFee = sc.nextDouble();
					list.add(new ImportedProduct(name,price,customsFee));
				break;
			}

		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for(Product1 prod: list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
