import java.util.Scanner;

public class Kalkulator {
	public static void main(String[] args) {
		System.out.println("Welcome to Kalkulator. Here you can perform complex math equations.");
		System.out.println("What type of calculation would you like to do?");
		System.out.println("Choose from the following options:");
		System.out.println("Factoring");
		System.out.println("Algebra");
		System.out.println("Basic");
		
		Scanner scnr = new Scanner(System.in);
		String input = scnr.next().toLowerCase();
		
		if (input.equals("factoring")) {
			//User wants to do a factoring equation
			//Probably call the FactorMath class
		}
		
		else if (input.equals("algebra")) {
			//User wants to do a factoring equation
			//Probably call the AlgebraMath class
		}
		
		else if (input.equals("basic")) {
			//User wants to do a factoring equation
			//Probably call the BasicMath class
		}
		
		else {
			System.out.println("Sorry for wasting your time.");
			return;
		}
		
	}
}