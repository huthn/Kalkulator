import java.util.Scanner;

public class BasicMath {
	
	//Works if input follows order of operations.
	//TODO fix the above...possible call the math methods from a different method (runner/reference type setup)
	//TODO make the variables doubles so it accepts specific division and input
	//TODO negative numbers
	
	private static String inputQuestion;
	
	public void start(String input) {
		System.out.println("You have selected Basic Math. Enter your problem now.");
		
		Scanner scnr = new Scanner(System.in);
		inputQuestion = scnr.nextLine().toLowerCase();
		
		String inputText = inputQuestion.replaceAll("\\*", "x").replaceAll("\\+", "#").replaceAll("\\s", "") + " ";
		equationCommand(inputText);
	}
	
	public static void equationCommand(String input) {
		//This method is intended to control the reducing of the input
		//Calls the reduceFunction with the correct type and index
		
		int multiplicationIndex = input.indexOf("x"); //The * symbol was replaced with x
		int divisionIndex = input.indexOf("/"); 
		int additionIndex = input.indexOf("#"); //The + symbol was replaced with #
		int subtractionIndex = input.indexOf("-");
		
		//TODO call the reduceFunction method
		//Remember to check if the index is equal to -1 before call the next one
		//Develop a way to check if there is only addition or subtraction left
		
		if (multiplicationIndex != -1 && divisionIndex != -1) {
			
			//There is only division and multiplication left
			System.out.println("Only division and multiplication left.");
		}
		
		else if (additionIndex != -1 && subtractionIndex != -1) {
			
			//There is only addition and subtraction left
			System.out.println("Only addition and subtraction left.");
		}
		
		
		if (multiplicationIndex != -1) {
			reduceFunction(input, "multiplication", multiplicationIndex);
		}
		
		else if (divisionIndex != -1) {
			reduceFunction(input, "division", divisionIndex);
		}
		
		else if (additionIndex != -1) {
			reduceFunction(input, "addition", additionIndex);
		}
		
		else if (subtractionIndex != -1) {
			reduceFunction(input, "subtraction", subtractionIndex);
		}
		
		else {
			System.out.println(inputQuestion + " = " + input);
		}
	}
	
	public static void reduceFunction(String input, String type, int operationIndex) {
		
		int startIndex = previousFunction(operationIndex, input);
		int endIndex = nextFunction(operationIndex, input);
		double firstSide;
		
		if (startIndex == 0) {
			
			firstSide = Double.parseDouble(input.substring(0, operationIndex));
		}
		
		else {
			
			firstSide = Double.parseDouble(input.substring(startIndex, operationIndex));
		}
		
		double secondSide = Double.parseDouble(input.substring(operationIndex+1, endIndex));
		double result = 0.0;
		
		if (type == "multiplication") {
			
			result = firstSide * secondSide;
		}
		
		else if (type == "division") {
			
			result = firstSide / secondSide;
		}
		
		else if (type == "addition") {
			
			result = firstSide + secondSide;
		}
		
		else if (type == "subtraction") {
			
			result = firstSide - secondSide;
		}

		String stringResult = Double.toString(result);
		
		String string = input.substring(startIndex, endIndex);
		String reducedString = input.replaceAll(string, stringResult);
			
		equationCommand(reducedString);
	}
	
	//These methods return the index+1 of the next function.
	//Parameters: startingIndex(int), input(String)
	public static int nextFunction(int start, String input) {
		for (int i = start+1; i < input.length(); i++) {
			if (input.charAt(i) == 'x' || input.charAt(i) == '/' || input.charAt(i) == '#' || input.charAt(i) == '-') {
				
				return i;
			}
			
		}
			//The end of the right value is the end of the string
			return input.length()-1;
	}
	
	public static int previousFunction(int start, String input) {
		for (int i = start-1; i > 0; i--) {
			if (input.charAt(i) == 'x' || input.charAt(i) == '/' || input.charAt(i) == '#' || input.charAt(i) == '-') {
				
				return i+1;
			}
			
		}
			//The beginning of the left value is the beginning of the string
			return 0;
	}
}