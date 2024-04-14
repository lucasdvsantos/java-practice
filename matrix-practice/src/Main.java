import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int lineNumber = sc.nextInt();
		int columnNumber = sc.nextInt();
		
		int[][] numbers = new int[lineNumber][columnNumber];
		
		for (int i=0; i<numbers.length; i++) {
			for(int j=0; j<numbers[i].length; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}
		
		int chosenNumber = sc.nextInt();
		
		for (int i=0; i<numbers.length; i++) {
			for (int j=0; j<numbers[i].length; j++) {
				if (numbers[i][j] == chosenNumber) {
					System.out.println("Position " + i + "," + j + ":");
					if (j > 0) {
						System.out.println("Left: " + numbers[i][j-1]);
					}
					if (i > 0) {
						System.out.println("Up: " + numbers[i-1][j]);
					}
					if (j < numbers[i].length - 1) {
						System.out.println("Right: " + numbers[i][j+1]);
					}
					if (i < numbers.length - 1) {
						System.out.println("Down: " + numbers[i+1][j]);
					}	
				}
			}
		}
		
		sc.close();
	}

}
