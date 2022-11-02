/*
 * Author: Neumann Davila
 * Date:   Oct 20, 2022
 * Description:
 *
 *
 * 
 */

package arrays;

import java.util.Scanner;

public class Book {
	//	A book contains an authour and a title
	
	private String title;
	private String author;
	
	public String toString() {
		return "Book [author=" + author + "";
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book() {
		this.title = "unknown";
		this.author = "unknown";
	}
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
}

