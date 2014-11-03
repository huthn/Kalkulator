import java.util.Scanner;

public class FactorMath {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String rawInput;
        System.out.println("This will factor out whatever ");
        System.out.println("Please input in the form: ax^2 + bx + c");
        System.out.println("If a = 1 then please input 1 into the form");
		rawInput = scan.nextLine();
		rawInput = rawInput.replaceAll("\\s+","");
		if(rawInput.contains("x") && rawInput.contains("^2")) {
			String a; String b; String c;
            double x; double y; double z; double count = 12; double count2 = 1; double count3;
			a = rawInput.substring(0, 1); 
			b = rawInput.substring(5,6);
            c = rawInput.substring(rawInput.length()-1, rawInput.length());

            x = Double.parseDouble(a);
            y = Double.parseDouble(b);
            z = Double.parseDouble(c);
            System.out.println(z);
            while(count2 < count) {
                count2++;
                if(z%count2 == 0) {
                    System.out.println(count2 + " is a factor of " + z);
                    count3 = count2;
                    if(y == (count3*2)) {
                        System.out.println(rawInput + " factored is equal to"+"(x + "+count3+")(x + "+count3+")");
                        return;
                    }
                }
                
            }
		
		}
		else {
		System.out.println("Please input in the form ax^2 + bx + c");
            return;
		}
	}
}