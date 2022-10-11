package numAnalyze;

public class NumAnalyze {
	
	public static void showDivisors(int userIn) {
			//	if the value isnt 0 then the method will execute
		if (userIn != 0) {
				//	all values are divisible by 1 so I initially print the number
			System.out.print("1");
			for (int i = 2; i < userIn; i++) {
					//	this checks id each value has a remainder and if there is no remainder then the number is printed
				if ((userIn % i) == 0) {
					System.out.print(", " + i);
				}
			}
			System.out.println(".");
		}
	}
	
	public static void isPrime(int userIn) {
			// creates bool that determines if the value is prime & makes the userIn positive
		boolean isPrime = true;
		userIn = Math.abs(userIn);
			//filters out a 0 input 
		if (userIn != 0) {
			//	checks every value inbetween 1 and userIn in order to determine if the number is prime 
			for (int i = 2; i < userIn; i++) {
				if ((userIn % i) == 0) {
						//	sets isPrime to true and brakes the for loop
					isPrime = false;
					break;
				}
			}
				//	displays the proper output depending on the value of isPrime
			if (isPrime == true) {
				System.out.println(userIn + " is a prime number.");
			}
			else {
				System.out.println(userIn + " is not prime.");
			}
			
		}
	}
	
	public static void factorial (int userIn) {
			//	if userIn is greater than one then the normal factorial program runs
		if (userIn > 1) {
			System.out.print(userIn + "! = " + userIn + " ");
			for (int i = userIn - 1; i > 0; i--) {
					//	this multiplies userIn by i for each iteration until i = 0 
				userIn *= i;
					//	displays the proper output
				System.out.print("x " + i + " ");
			}
			System.out.println("= " + userIn);
		}
			//	if userIn is negative then -1 is the output
		else if (userIn < 0) {
			System.out.println(userIn + "! = -1.");
		}
			//	if userIn is 0 or 1 then the method displays 1
		else {
			System.out.println(userIn + "! = 1.");
		}
	}
																						
	public static void contains(int userIn, int searchValue) {
			//	converts the int that is being searched into a string so I can search for the value
		String  userString= "" + userIn;
			//	tests to see if the value is in the new string
		int searchIndex = userString.lastIndexOf("" + searchValue);
			//	if the value is in the string then the program will start to run
		if (searchIndex != -1) {
				//	while  loop finds each time the value is found in the string from end - front
			while (searchIndex != -1) {
				String tempString = "1";
					//	for loop will add a 0 to userString for each value after the one identified 
				for (int j = searchIndex; j < userString.length() - 1;j++ ) {
					tempString += "0"; 
				}
				System.out.println(tempString);
					//	sets the value for the next searchIndex
				searchIndex = userString.lastIndexOf("" + searchValue , searchIndex - 1);
			}
		}
	}
	
	public static void main(String[] args) {
	}
}
