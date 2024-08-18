package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Map<String, Integer> votesEntry = new LinkedHashMap<>();
			
			String line = br.readLine();
			while(line != null) {
				
				String[] fields = line.split(", ");
				String candidateName = fields[0];
				int votesCount = Integer.valueOf(fields[1]);
				
				if (votesEntry.containsKey(candidateName)) {
					int currentCount = votesEntry.get(candidateName);
					int summVotes = currentCount + votesCount;
					votesEntry.put(candidateName, summVotes);
				} else {
					votesEntry.put(candidateName, votesCount);
				}
				
				line = br.readLine();
				
			}
			
			for (String key : votesEntry.keySet()) {
				System.out.println(key + ": " + votesEntry.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
		
	}

}
