/*
 * Author: Neumann Davila
 * Date:   Sep 15, 2022
 * Description:
 * Creates a gmu email by collectign the first middle and ast name of the individual
 * it will also sne d a confirmation code and give a random 8 character password
 *
 * 
 */

package loginInfo;

import java.util.Random;
import java.util.Scanner;

public class LoginManager {
	static Random rand = new Random();
	
	public static void main(String[] args) {
		run();

	}
	
	// static ensures that the object exist for the entire class and not just the methods
	static Scanner input = new Scanner(System.in);
	
	
	
		// collects the general info required for the email adress
	public static void getInfo() {
		String first, middle, last;
		
		System.out.println("What is your first name");
		first = input.nextLine();
		
		System.out.println("What is your middle name");
		middle = input.nextLine();
		
		System.out.println("What is your last name");
		last = input.nextLine();
		
		System.out.println("At the end of this program you will have a GSIP email address and a temporary password.");
		System.out.println("Your email address is: " + getEmailAddress(first , middle , last) + ".");
		System.out.println("Your password is: " + getPassword());
		System.out.println("A confirmation code has been sent to your email");
	}
	
		//formats the names in order to create a proper email address
	public static String getEmailAddress(String first, String middle, String last) {
		String email = "";
		
		if(last.length() >= 7) {
			email += last.substring(0 , 6).toLowerCase();
			email += first.substring(0 , 1).toUpperCase() + middle.substring(0 , 1).toUpperCase();
			email += "@GSIP.edu";
		}
		else {
			email += last.toLowerCase();
			email += first.substring(0 , 1).toUpperCase() + middle.substring(0 , 1).toUpperCase();
			email += "@GSIP.edu";
		}
		
		return email;
	}
	
		//creates an 8 digit password 
	public static String getPassword() {
			//creates a set of characters to pull from to create a password
		String characters ="abcdefghijklmnopqrstuvwxyz";
		characters += characters.toUpperCase();
		characters += "!@#$^&*";
		
		String password = "";
		
			//creates a random number with the bounds of the length of the characters string 
		int x = rand.nextInt(characters.length());	
			// adds the character that was selected randomlly to the password string
		password += characters.substring(x, x+1);
		
		x = rand.nextInt(characters.length());	
		password += characters.substring(x, x+1);

		x = rand.nextInt(characters.length());	
		password += characters.substring(x, x+1);

		x = rand.nextInt(characters.length());	
		password += characters.substring(x, x+1);

		x = rand.nextInt(characters.length());	
		password += characters.substring(x, x+1);

		x = rand.nextInt(characters.length());	
		password += characters.substring(x, x+1);

		x = rand.nextInt(characters.length());	
		password += characters.substring(x, x+1);

		x = rand.nextInt(characters.length());	
		password += characters.substring(x, x+1);
		
		return password;
	}

		//creates a 6 digit confirmation code
	public static int getConfirmation() {
		
		
		return rand.nextInt(999999 - 100000 + 1) + 100000 ;
	}
	
	public static void run() {
		getInfo();
	}

}

