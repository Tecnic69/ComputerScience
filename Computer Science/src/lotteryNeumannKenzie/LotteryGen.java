/*
 * Author: Neumann Davila
 * Date:   Sep 20, 2022
 * Description:
 *
 *
 * 
 */

package lotteryNeumannKenzie;

import java.util.Random;
import java.util.Scanner;

public class LotteryGen {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random digitGen = new Random();
		
		String lotto = "";
		String lottoIn;
		
		lotto += (digitGen.nextInt(9000) + 1000);
		String digit1 = lotto.substring(0,1);
		String digit2 = lotto.substring(1,2);
		String digit3 = lotto.substring(2,3);
		String digit4 = lotto.substring(3);
		
		System.out.println("PLease type out a 4 digit number");
		lottoIn = input.nextLine();
	
			if(lottoIn == lotto) {
				System.out.println("Congrats! You guessed the lottery number. You won $100,000.");
				}
			else if(lottoIn.indexOf(digit1) != -1 && lottoIn.indexOf(digit2) != -1 && lottoIn.indexOf(digit3) != -1 && lottoIn.indexOf(digit4) != -1) {
				System.out.println("You guessed all the correct lottery numbers... but in the wrong order.");
				System.out.println("You won $25,000.");
			}
			else if(lottoIn.indexOf(digit1) != -1 || lottoIn.indexOf(digit2) != -1 || lottoIn.indexOf(digit3) != -1 || lottoIn.indexOf(digit4) != -1) {
				System.out.println("You guessed one number correctly.");
				System.out.println("You win $5");
				}
			else {
				System.out.println("You didn't win. :(");
			}
			
			
	}
}

