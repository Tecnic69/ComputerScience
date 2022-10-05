/*
 * Author: Neumann Davila
 * Date:   Sep 28, 2022
 * Description:
 * Derrivative calculator cause I am bored
 *
 * 
 */

package mathCalculator;

import java.util.Scanner;

public class DerrivativeCalculator {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String userIn;
		char variable;
		
			//	Checks which variable to use for derriving the equation
		System.out.println("Declare the variable are you derriving.");
		userIn = input.nextLine();
		variable = userIn.charAt(0);
		
		System.out.println("Please type your equation with a space beween operators.");
		userIn = input.nextLine();
		userIn = userIn.replace(" ", "");
		userIn += " ";
		derriveFunction(userIn, variable);

	}
	
	public static void derriveFunction(String userIn, char variable) {
		int lastOp;
		int nextOp;
		int currentPowIndex;
		int currentVarIndex;
		String currentChunk;

		lastOp = 0;											//	sets lastOp to 0 becuase the program must start at the 0 string index
		nextOp = checkNearestSepOp(userIn, 0);				//	the next op is set to he index of the next +, - or length of the String
		currentChunk = userIn.substring(lastOp , nextOp);	//	creates a chunk that I can better work with
		currentPowIndex = currentChunk.indexOf("^");		//	finds the next Index of "^" so that I can push it through the power rule method
		currentVarIndex = currentChunk.indexOf(variable);	//	finds the next variableindex whish is currently useless --> might delete
		
			//	if the lastOp used is greater than the userIn.length then the loop has iterated to the end of the function/userIn
		while (lastOp < userIn.length()) {
			if (currentPowIndex != -1) {	// if there is a "^" then the info is input into the powerRule method
				System.out.print(powerRule(currentChunk, lastOp, currentPowIndex, variable));
			}
			else if (currentVarIndex != -1) {	//	if there is not a "^" then the variable is replaced							*** ADD CONSTANT TO 0 ***
				System.out.print(currentChunk.replace("" + variable, ""));
			}
			
			nextOp = checkNearestSepOp(userIn, nextOp);
			currentChunk = userIn.substring(lastOp, nextOp);
			currentPowIndex = currentChunk.indexOf("^");
			currentVarIndex = currentChunk.indexOf(variable);
			lastOp = nextOp;
		}
		System.out.println("");
	}
		// Detects the amount of seperatting operators in an equation
		// 
	public static int getSepOpAmount(String userIn) {
		int totalIndex = 0;
		int KnownOp = 0;
		int lastOp = userIn.length() - 1;
		while (KnownOp < lastOp) {
			
			KnownOp = checkNearestSepOp(userIn, KnownOp);
			System.out.println(totalIndex);
			totalIndex ++;
			
		}
		return totalIndex;
	}
		//	Checks the nearest Seperatting Operator --> + or - , as these are not operators with specific rules
		// 	therefor we can use thee to help evaluate the start of a mathmatical "phrase"
	public static int checkNearestSepOp(String userIn, int StartIndex) {
		int nextPlus, nextMinus;
		
		nextPlus = userIn.indexOf("+", StartIndex);
		nextMinus = userIn.indexOf("-", StartIndex);
		
		if (nextPlus != -1 && nextMinus != -1) {
			if (nextPlus < nextMinus) {
				return nextPlus;
			}
			else {
				return nextMinus;
			}
		}
		else if (nextMinus == -1 && nextPlus > -1){
			return nextPlus;
		}
		else if (nextPlus == -1 && nextMinus > -1) {
			return nextMinus;
		}
		else {
			return userIn.length() - 1;
		}
	}
	
		
		// Checks for any operators that require a rule
		// This would be any multiplication, division or power 
	public static int checkNearestRuleOp (String userIn, int lastKnown) {
		int nearestMult, nearestDiv, nearestPow;

		return nearestPow = userIn.indexOf("^", lastKnown);
	}
	
		//Breaks down a string to determine the compnents required for the power rule
	public static String powerRule(String userIn, int lastKnownIndex, int currentPowIndex, char variable) {
		String answer = "";
			//	singles out the coefficient by
		int coefficient = Integer.parseInt(userIn.substring(lastKnownIndex, userIn.indexOf(variable)));
		int pow = Integer.parseInt(userIn.substring(currentPowIndex + 1));
		
		coefficient *= pow;
		pow -= 1;
		if (pow != 1 && pow != 0) {
			answer += coefficient + "" + variable + "^" + pow;
		}
		else if (pow == 1) {
			answer += coefficient + "" + variable;
		}
		else {
			answer += coefficient;
		}
		return answer;
	}
		// start of the trig functions function
	public static String trigFunctions(boolean isNeg,int coefficient, String trigIn, String innervalue) {
		String answer = "";
			//	Finds the derrivative of the originial trig function regardless of the sign of the function
		if (trigIn.equals("sin")) {
			answer = "cos(";
		}
		else if (trigIn.equals("cos")) {
			answer = "-sin(";
		}
		else if (trigIn.equals("tan")) {
			answer = "sec^2(";
		}
		else if (trigIn.equals("csc")) {
			answer = "-csc( )cot(";
		}
		else if (trigIn.equals("sec")) {
			answer = "sec( )tan(";
		}
		else if (trigIn.equals("cot")) {
			answer = "-csc^2(";
		}
		
			//	Determines the sign of the trig function
		if (isNeg == true) {
			if (answer.charAt(0) == '-') {
				answer = answer.substring(1);
			}
			else {
				answer = "-" + answer;
			}
		}
		return answer;
	}

	
}

