/*
 * Author: Neumann Davila
 * Date:   Oct 20, 2022
 * Description:
 *
 *
 * 
 */

package zyLabs;

import java.util.Random;

public class Dice {
	private Random rand = new Random();
	private int dice1Sides;
	private int dice2Sides;
	
	public String toString() {
		String summary = "Die1 - " + dice1Sides + " sides\nDie2 - " + dice2Sides + " sides";
		
		summary += "\n\n" + (dice1Sides * dice2Sides) + " possibe Outcomes\n\n";
		
		for(int i = 1; i <= dice1Sides; i++) {
			for(int j = 1; j <= dice2Sides; j++) {
				summary += "(" + i + "," + j + ")\t";
			}
			summary += "\n";
		}
		
		
		return summary;
	}
	
	public void setDice1Sides(int sides) {
		if(sides >= 4 && sides <= 20) {
			this.dice1Sides = sides;
		}
		else {
			this.dice1Sides = 6;
		}
	}
	
	public void setDice2Sides(int sides) {
		if(sides >= 4 && sides <= 20) {
			this.dice2Sides = sides;
		}
		else {
			this.dice2Sides = 6;
		}
	}
	
	public int getDice1Sides() {
		return rand.nextInt(dice1Sides) + 1;
	}
	
	public int getDice2Sides() {
		return rand.nextInt(dice2Sides) + 1;
	}
	
	public Dice() {
		this.dice1Sides = 6;
		this.dice1Sides = 6;
	}
	
	public Dice(int sides) {
		setDice1Sides(sides);
		setDice2Sides(sides);
	}
	
	public Dice(int sides1, int sides2) {
		setDice1Sides(sides1);
		setDice2Sides(sides2);
	}
	
}

