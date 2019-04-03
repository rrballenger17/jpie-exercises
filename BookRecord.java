
import java.util.*;
import java.lang.reflect.*;

public final class BookRecord {

	private String author; 
	private String bookTitle;

	public BookRecord(String author, String bookTitle) { 
		this.author = author;
		this.bookTitle = bookTitle;
	}

	public String getAuthor() { return author;}

	public String getBookTitle() { return bookTitle;} 


	public static void main(String args[]){
		final BookRecord record = new BookRecord("Suzanne Collins",
			"The Hunger Games");

		try{
			final Field author = record.getClass().getDeclaredField("author"); 
			author.setAccessible(true);
			author.set(record, "Catching Fire");

		}catch(Exception e){
			// to-do
		}


		System.out.println(record.getAuthor());		
	}


}
