import java.util.Scanner;

public class BasicMath {
	
	private static String inputQuestion;
	
	public static void main(String[] args) {
		System.out.println("You have selected Basic Math. Enter your problem now.");
		
		Scanner scnr = new Scanner(System.in);
		inputQuestion = scnr.nextLine().toLowerCase();
		
		String inputText = inputQuestion.replaceAll("\\*", "x").replaceAll("\\+", "#").replaceAll("\\s", "") + " ";
		BasicMath.getAnswer(inputText);
	}
	
	public static void getAnswer(String input) {
		BasicMath.reduceParentheses(input);
		
		//System.out.println(input + " simplified from the parentheses is " + string);
	}
	
	public static void reduceParentheses(String input) {
		int parenthesesIndex = BasicMath.parenthesesSymbol(input);
		if (parenthesesIndex == -1) {
			//There are no more parentheses
			BasicMath.reduceMultiplication(input);
		}
		
		else {
			int startingIndex = input.indexOf("(");
			int finishingIndex = input.indexOf(")");
			String parenString = input.substring(startingIndex+1, finishingIndex);
			System.out.println("Inside the parentheses is " + parenString);
			String reducedString = input.replaceAll(input, parenString);
			
			BasicMath.reduceParentheses(reducedString);
		}
	}
	
	public static void reduceMultiplication(String input) {
		int multiplicationIndex = BasicMath.multiplicationSymbol(input);
		if (multiplicationIndex == -1) {
			//There is no multiplication in the parentheses
			BasicMath.reduceDivision(input);
		}
		
		else {
			
			int firstSide = Character.getNumericValue(input.charAt(multiplicationIndex-1));
			int secondSide = Character.getNumericValue(input.charAt(multiplicationIndex+1));
	
			int result = firstSide*secondSide;
			String stringResult = Integer.toString(result);
		
			String multiplicationString = input.substring(multiplicationIndex-1, multiplicationIndex+2);
			String reducedString = input.replaceAll(multiplicationString, stringResult);
				
			BasicMath.reduceMultiplication(reducedString);			
		}
	}
	
	public static void reduceDivision(String input) {
		int divisionIndex = BasicMath.divisionSymbol(input);
		if (divisionIndex == -1) {
			//There is no division
			BasicMath.reduceAddition(input);
		}
		
		else {
			
			int firstSide = Character.getNumericValue(input.charAt(divisionIndex-1));
			int secondSide = Character.getNumericValue(input.charAt(divisionIndex+1));
	
			int result = firstSide/secondSide;
			String stringResult = Integer.toString(result);
		
			String divisionString = input.substring(divisionIndex-1, divisionIndex+2);
			String reducedString = input.replaceAll(divisionString, stringResult);
		
			BasicMath.reduceDivision(reducedString);
		}
	}
	
	public static void reduceAddition(String input) {
		int additionIndex = BasicMath.additionSymbol(input);
		if (additionIndex == -1) {
			//There is no more addition
			BasicMath.reduceSubtraction(input);
		}
		
		else {
			
			int firstSide = Character.getNumericValue(input.charAt(additionIndex-1));
			int secondSide = Character.getNumericValue(input.charAt(additionIndex+1));
	
			int result = firstSide+secondSide;
			String stringResult = Integer.toString(result);
					
			String additionString = input.substring(additionIndex-1, additionIndex+2);
			String reducedString = input.replaceAll(additionString, stringResult);
			
			BasicMath.reduceAddition(reducedString);
		}
	}
	
	public static void reduceSubtraction(String input) {
		int subtractionIndex = BasicMath.subtractionSymbol(input);
		if (subtractionIndex == -1) {
			//There is no more subtraction
			System.out.println(inputQuestion + " = " + input);
		}
		
		else {
			
			int firstSide = Character.getNumericValue(input.charAt(subtractionIndex-1));
			int secondSide = Character.getNumericValue(input.charAt(subtractionIndex+1));
	
			int result = firstSide-secondSide;
			String stringResult = Integer.toString(result);
					
			String subtractionString = input.substring(subtractionIndex-1, subtractionIndex+2);
			String reducedString = input.replaceAll(subtractionString, stringResult);
			
			BasicMath.reduceSubtraction(reducedString);
		}
		
	}
	
	
	//These methods determine the index of the symbol (division, multiplication, addition, subtraction)
	//They are unnecessary
	private static int parenthesesSymbol(String input) {
		if (input.indexOf("(") == -1) return -1;
		return input.indexOf("("); 
	}
	
	private static int multiplicationSymbol(String input) {
		if (input.indexOf("x") == -1) return -1;
		return input.indexOf("x"); 
	}
	
	private static int divisionSymbol(String input) {
		if (input.indexOf("/") == -1) return -1;
		return input.indexOf("/");
	}
	
	private static int additionSymbol(String input) {
		if (input.indexOf("#") == -1) return -1;
		return input.indexOf("#");
	}
	
	private static int subtractionSymbol(String input) {
		if (input.indexOf("-") == -1) return -1;
		return input.indexOf("-");
	}
}