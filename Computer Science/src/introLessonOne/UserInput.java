/*
 * Author: Neumann Davila
 * Date:   Aug 25, 2022
 * Description:
 *
 *
 * 
 */

package introLessonOne;

//import is used to import classes and allow this class to use its methods
import java.util.Scanner;
//Scanner is used to take inputs from the user


// The syntax to create any object in java is:
// ClassName yourObjectName = ClassName(parameterList);

public class UserInput {
	
	public static void main(String[] args) {
		
		Scanner keeb = new Scanner(System.in);
		
		System.out.println("What is your name.");
		
		String name = keeb.nextLine();
		System.out.println("Your name is " + name + ".");
	}
	
}

