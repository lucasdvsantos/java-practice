package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Product> products = new ArrayList<Product>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("/home/iagodvsantos/products.csv"))) {
			String line = br.readLine();
			
			while (line != null) {
				String name = line.split(",")[0];
				Double price = Double.parseDouble(line.split(",")[1]);
				Integer quantity = Integer.parseInt(line.split(",")[2]);
				products.add(new Product(name, price, quantity));
				line = br.readLine();
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		if (new File("/home/iagodvsantos/out").mkdir()) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/iagodvsantos/out/summary.csv"))) {
				for (Product p : products) {
					bw.write(p.getName() + "," + String.format("%.2f", p.totalPrice()));
					bw.newLine();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
