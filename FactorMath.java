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
                aMoreThanOne(a, b, c);
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
        double answer; double answer1; double[] factors = new double[1];
        findFactors(a, b, c);
        return factors;
    }
    
    public static double[] findFactors(double a, double b, double c) {
        int COUNT = 120; int count1 = 0; int x = 0; double rand = 0;
        double[] factorsA = new double[COUNT];
        double[] factorsB = new double[COUNT];
        int count2 = 0; int y = 0; double rand2 = 0;
        //Check to see if they are factors
        while(x < COUNT) {
            //If they are factors store
            x++;
            if(a % x == 0) {
                rand = a/x;
                factorsA[count1] = rand;
                count1++;
                factorsA[count1] = x;
                count1++;
            }
        }
        while(y < COUNT) {
            y++;
            if(c % y == 0) {
                rand2 = c/y;
                factorsB[count2] = rand2;
                count2++;
                factorsB[count2] = y;
                count2++;
            }
        }
        System.out.println(factorsA[0] + ", " +factorsA[1] + ", " +factorsA[2] + ", " +factorsA[3] + ", "+ factorsA[4] + ", " + factorsA[5] + ", "+factorsB[0] + ", " +factorsB[1] + ", " +factorsB[2] + ", " +factorsB[3] + ", "+ factorsB[4] + ", ");
        //Now that factors are found, multiply the values together
        //Once multiplied check to see if they add up to equal b
        int loopCount1 = 1;  int loopCount2 = COUNT; int extraNum = 0; int extraNum2 = 2; int extraNum3 = 3;
        double[] arrayStorer = new double[COUNT];
        while(loopCount1 < COUNT) {
            loopCount1++;
            //This stores the first two values of the four numbers
            //(EG: (x,y) (a,b)= xa + yb)
            arrayStorer[extraNum] = factorsA[extraNum] * factorsB[extraNum];
            arrayStorer[loopCount1] = factorsA[loopCount1] * factorsB[loopCount1];
            //This stores the other possible mutliples of the 4 numbers
            arrayStorer[extraNum2] = factorsA[extraNum] * factorsB[loopCount1];
            arrayStorer[extraNum3] = factorsA[loopCount1] * factorsB[extraNum];
        }
        //Create 4 new loops to test every possible integer combo
        //Make new variables for loops
        double answer[] = new double[COUNT];
        int loop1 = 0; int loop2 = 2; int loop3 = COUNT; int loop4 = COUNT - 2;
        while (loop1 < COUNT) {
            if((arrayStorer[loop1] + arrayStorer[loop2])== b) {
                System.out.println(arrayStorer[loop1] + arrayStorer[loop2]);
                answer[0] = arrayStorer[loop1];
                answer[1] = arrayStorer[loop2];
            }
        }
        return factorsA;
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
