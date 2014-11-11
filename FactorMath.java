import java.util.Scanner;

public class FactorMath {

	public static void main(String[] args) {
        double a; double b; double c;
        Scanner scan = new Scanner(System.in);
		String rawInput;
        System.out.println("");
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("This will factor any polynomial");
        System.out.println("Please input in the form: ax^2 + bx + c");
        System.out.println("Use (shift + 6) and 2 for the symbol ^2");
        System.out.println("If a = 1 then please input 1 into the a value");
		rawInput = scan.nextLine();
		rawInput = rawInput.replaceAll("\\s+","");
		if(rawInput.contains("^2")) {
            double count = 12; double count2 = 1; double count3;
            double[] nums = returnNum(rawInput);
            a = nums[0]; b = nums[1]; c = nums[2];
            if(a != 1) {
                System.out.println("We are still working on factoring when 'a' is more than 1");
                return;
            }
            else {
                returnAnswer(quadFormulaMinus(a,b,c), quadFormulaPlus(a,b,c));
            }
		}
		else {
            System.out.println("Please input in the form ax^2 + bx + c");
            System.out.println("For example, this is a valid function: 1x^2 + 4x + 6");
            main(args);
            return;
		}
    }
    public static double[] aMoreThanOne(double a, double b, double c) {
        double answer; double answer1;
        double[] factors1 =
        answer = quadFormulaMinus(a,b,c);
        answer1 = quadFormulaPlus(a,b,c);
        
        
        
    }
    
    public static double[] returnNum(String x) {
        String part1 = ""; String part2 = ""; String part3 = "";
        double a = 0; double b = 0; double c = 0; int count2 = x.length();
        while(count2 > 0) {
            count2--;
            if(x.charAt(count2) == '+') {
                part3 = x.substring(count2+1,x.length());
                c = Double.parseDouble(part3);
                break;
            }
            if(x.charAt(count2) == '-') {
                part3 = x.substring(count2+1,x.length());
                c = Double.parseDouble(part3);
                c = c*-1;
                break;
            }
        }
        int count;
        count = count2 - 1;
        while(count > 0) {
            count--;
            if(x.charAt(count) == '+') {
                part2 = x.substring(count+1, count2-1);
                b = Double.parseDouble(part2);
                break;
            }
            if(x.charAt(count) == '-') {
                part2 = x.substring(count+1, count2-1);
                b = Double.parseDouble(part2);
                b = b*-1;
                break;
            }
        }
        int count1;
        count1 = count - 3;
        part1 = x.substring(0, count1);
        a = Double.parseDouble(part1);
        double[] returnArray = {a, b, c};
        
        return returnArray;
    }
    
    public static String returnAnswer(double a, double b) {
        String answer = "";
        if(a < 0 && b < 0) {
            a = a * -1;
            b = b * -1;
            answer = ("Your number factored is: (x + "+a+")(x + "+b+")");
        }
        else if(a>0 && b > 0) {
            answer = ("Your number factored is: (x - "+a+")(x - "+b+")");
        }
        else if(a>0 && b <0) {
            b = b * -1;
            answer = ("Your number factored is: (x - "+a+")(x + "+b+")");
        }
        else if(a<0 && b>0) {
            a = a * -1;
            answer = ("Your number factored is: (x + "+a+")(x - "+b+")");
        }
        else {
            answer = "We may not have the capabilities of solving your problem yet or there was an error in the program";
        }
        System.out.println(answer);//TEST
        return answer;
    }

    public static double quadFormulaPlus(double a, double b, double c) {
        double root; double div; double plus1;double answer1;
        root = (b*b)-(4*(a*c));
        if(root < 0) {
            root = root * -1;
            div = Math.sqrt(root);
            plus1 = (-1*b) + div;
            answer1 = plus1/(2*a);
            return answer1;
        }
        else {
            div = Math.sqrt(root);
            plus1 = (-1*b) + div;
            answer1 = plus1/(2*a);
            return answer1;
        }
    }
    
    public static double quadFormulaMinus(double a, double b, double c) {
        double root; double div; double plus1;double answer1;
        root = (b*b)-(4*(a*c));
        if(root < 0) {
            root = root * -1;
            div = Math.sqrt(root);
            plus1 = (-1*b) - div;
            answer1 = plus1/(2*a);
            return answer1;
        }
        else {
            div = Math.sqrt(root);
            plus1 = (-1*b) - div;
            answer1 = plus1/(2*a);
            return answer1;
        }
    }
}
