import java.util.Scanner;

public class Programmingtest {
	public static void main(String[] args) {
		try (Scanner scnr = new Scanner(System.in)) {
			int x;
			int y;
			
			System.out.print("Enter an Interger: ");
			x = scnr.nextInt();
			y = x * 5;
			System.out.println(y);
		}
	}
}