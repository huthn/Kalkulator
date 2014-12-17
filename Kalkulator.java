import java.util.Scanner;
import javax.swing.JOptionPane;

public class Kalkulator {
	public static void main(String[] args) {

        System.out.println("   ");
        System.out.println("   ");
        System.out.println("Welcome to Kalkulator. Here you can perform complex math equations.");
		System.out.println("What type of calculation would you like to do?");
		System.out.println("Choose from the following options:");
		System.out.println("1. Factoring");
		System.out.println("2. PEMDAS");
        System.out.println("3. Basic Math");
		
		Scanner scnr = new Scanner(System.in);
		String input = scnr.next().toLowerCase();
        String[] str = new String[1];
        str[0] = "test";
        
		if (input.equals("factoring")) {
			//User wants to do a factoring equation
			//Probably call the FactorMath class
            
            Scanner scan = new Scanner(System.in);
            FactorMath factoring = new FactorMath();
            factoring.main(str);
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("Thank you for using Kalkulator. Do you want to do another calculation?");
            System.out.println("Type: yes or no");
            String input2 = scan.next().toLowerCase();
            if(input2.equals("yes")) {
                Kalkulator.main(str);
            }
            else if(input2.equals("no")) {
                System.out.println("Thank you for using the Kalkulator program!");
                return;
            }
            
        }
		
		else if (input.equals("pemdas")) {
			//User wants to do a factoring equation
			//Probably call the AlgebraMath class
			
            Scanner scan = new Scanner(System.in);
            BasicMath basic = new BasicMath();
            basic.start(str[0]);
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("Thank you for using Kalkulator. Do you want to do another calculation?");
            System.out.println("Type: yes or no");
            String input2 = scan.next().toLowerCase();
            if(input2.equals("yes")) {
                Kalkulator.main(str);
            }
            else if(input2.equals("no")) {
                System.out.println("Thank you for using the Kalkulator program!");
                return;
            }
		}
		
		else if (input.equals("basic")) {
			//User wants to do a factoring equation
			//Probably call the BasicMath class
			
			Scanner scan = new Scanner(System.in);
            BasicMath basic = new BasicMath();
			basic.start(str[0]);
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("Thank you for using Kalkulator. Do you want to do another calculation?");
            System.out.println("Type: yes or no");
            String input2 = scan.next().toLowerCase();
            if(input2.equals("yes")) {
                Kalkulator.main(str);
            }
            else if(input2.equals("no")) {
                System.out.println("Thank you for using the Kalkulator program!");
                return;
            }
		}
		
		else {
			System.out.println("Sorry for wasting your time.");
			return;
		}
	}
}