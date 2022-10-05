/*
 * Author: Neumann Davila
 * Date:   Aug 30, 2022
 * Description:
 *	Calculates mean, mdeaian, and mode of the provided value
 *
 * 
 */

package introLessonOne;


import java.util.Random;


public class NumberSummary {
	
	public static void main(String[] args) {
		
		int number1, number2, number3, sum, maxValue, minValue, median = 0;
		double mean;
		
		
		Random numGen = new Random();	//creates random object named numGen
		
		number1 = numGen.nextInt(50) + 1;	//assigns 'number1' a random number from 0-50
		number2 = numGen.nextInt(50) + 1;
		number3 = numGen.nextInt(50) + 1;
		
		sum = number1 + number2 + number3;
		mean = sum / 3.0;
		
			//Math.max() & Math.min() --> Detecets the max/min value in a set of values 
		
		maxValue = Math.max(Math.max(number1, number2), number3);
		minValue = Math.min(Math.min(number1, number2), number3);
		
		if(number1 != minValue) {
			if(number1 != maxValue){
				median = number1;
			}
		}
		else if(number2 != minValue) {
			if(number2 != maxValue) {
				median = number2;
			}
		}
		else if(number3 != minValue) {
			if(number3 != maxValue) {
				median = number3;
			}
		}
		
		
		System.out.println("Number Summary");
		System.out.println("--------------");
		System.out.println("The Numbers in order are : " + minValue + ", " + median + ", " + maxValue);
		System.out.println("Mean: " + mean );
		System.out.println("Median: " + median );
		System.out.println("Maximum Value: " + maxValue );
		System.out.println("Minimum Value: " + minValue);
		
		
	}
	
	
}
