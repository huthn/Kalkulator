import java.util.Scanner

public class FactorMath {

	public static void main(Strin[] args) {
		Scanner scan = new Scanner(System.in);
		String rawInput;
		System.out.println("This will factor out whatever ")
		System.out.println("Please input in the form: ax^2 + bx + c")
		rawInput = scan.nextLine();
		rawInput = rawInput.replaceAll("\\s+","");
		if(rawInput.contains("x") && rawInput.contains("^2") {
			String a; String b; String c;
			a = rawInput.substring(0, 1); 
			b = rawInput.substring();
			c = rawInput.substring()
		
		}
		else {
		System.out.println("Please input in the form ax^2 + bx + c");
		main();
		}
	}
}