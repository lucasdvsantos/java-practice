package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				Double cf = sc.nextDouble();
				
				products.add(new ImportedProduct(name, price, cf));
			}
			
			if(ch == 'c') {
				products.add(new Product(name, price));
			}
			
			if(ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				String md = sc.nextLine();
				
				products.add(new UsedProduct(name, price, sdf.parse(md)));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS");
		for(Product prod : products) {
			System.out.println(prod.priceTag());
		}

		sc.close();
	}

}
