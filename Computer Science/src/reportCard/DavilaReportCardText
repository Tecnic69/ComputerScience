/*
 * Author: Neumann Davila
 * Date:   Sep 26, 2022
 * Description:
 * Collects The data necissary for a report card inculding, School name, student name, and 7 class names and grades.
 * This program will also format the data in an easy to read fasion.
 */

package reportCard;

import java.util.Scanner;

public class ReportCard {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String schoolName;
		String studentName;
		String className1, className2, className3, className4, className5, className6, className7;
		int classGrade1, classGrade2, classGrade3, classGrade4, classGrade5, classGrade6,classGrade7;
			//	Collects the school name and student name of where the report card is from
		System.out.println("Please provide your school name.");
		schoolName = input.nextLine();
		System.out.println("Please provide your name.");
		studentName = input.nextLine();
			//	Collects the class Name and class percentage for every class 
		System.out.println("Please provide the grade and name for each class, seperated by a space, then click enter");
		System.out.printf("Example: \n91 Computer Science\n80 Physics\n");
		classGrade1 = input.nextInt();
		className1 = input.nextLine().substring(1);
		classGrade2 = input.nextInt();
		className2 = input.nextLine().substring(1);
		classGrade3 = input.nextInt();
		className3 = input.nextLine().substring(1);
		classGrade4 = input.nextInt();
		className4 = input.nextLine().substring(1);
		classGrade5 = input.nextInt();
		className5 = input.nextLine().substring(1);
		classGrade6 = input.nextInt();
		className6 = input.nextLine().substring(1);
		classGrade7 = input.nextInt();
		className7 = input.nextLine().substring(1);
			//	formats all the collected data
		System.out.println(schoolName);
		System.out.println(studentName);
		System.out.printf("\n%-30s %3d %s", className1, classGrade1 ,getLetterGrade(classGrade1));
		System.out.printf("\n%-30s %3d %s", className2, classGrade2 ,getLetterGrade(classGrade2));
		System.out.printf("\n%-30s %3d %s", className3, classGrade3 ,getLetterGrade(classGrade3));
		System.out.printf("\n%-30s %3d %s", className4, classGrade4 ,getLetterGrade(classGrade4));
		System.out.printf("\n%-30s %3d %s", className5, classGrade5 ,getLetterGrade(classGrade5));
		System.out.printf("\n%-30s %3d %s", className6, classGrade6 ,getLetterGrade(classGrade6));
		System.out.printf("\n%-30s %3d %s", className7, classGrade7 ,getLetterGrade(classGrade7));
	}
		//	returns the proper letter grade for the percentage provided
	public static char getLetterGrade (int classGrade) {
		if (classGrade >= 90) {
			return'A';
		}
		else if (classGrade >= 80 && classGrade < 90) {
			return'B';
		}
		else if (classGrade >= 70 && classGrade < 80) {
			return'C';
		}
		else if (classGrade >= 60 && classGrade < 70) {
			return'D';
		}
		else {
			return'F';
		}	
	}
}
	


