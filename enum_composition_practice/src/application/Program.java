package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Client client1 = new Client();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		client1.setName(sc.nextLine());
		System.out.print("Email: ");
		client1.setEmail(sc.nextLine());
		System.out.print("Birth date (DD/MM/YYYY): ");
		client1.setBirthDate(sdf.parse(sc.nextLine()));
		
		Order order1 = new Order();
		order1.setMoment(new Date());
		order1.setClient(client1);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		order1.setStatus(OrderStatus.valueOf(sc.nextLine()));
		System.out.print("How many items to this order? ");
		int itemsAmount = sc.nextInt();
		
		for (int i = 1; i <= itemsAmount; i++) {
			System.out.println("Enter #" + i + " item data:");
			Product prod = new Product();
			sc.nextLine();
			System.out.print("Product name: ");
			prod.setName(sc.nextLine());
			System.out.print("Product price: ");
			prod.setPrice(sc.nextDouble());
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem od = new OrderItem(quantity, prod);
			order1.addItem(od);
			
		}
		
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order1);
		
		sc.close();

	}

}
