package example;


public class Book {
	   private String isbn;
	   private String title;
	   private String author;
	   
	   Book() {
	   }
	   
	   @Override
	   public String toString() {
		   return isbn + " " + title + " " + author;
	   }
	   
	   public Book(String isbn, String title, String author) {
	       this.isbn = isbn;
	       this.title = title;
	       this.author = author;
	   }
	   
	   public String getIsbn() {
	       return this.isbn;
	   }
	   public void setIsbn(String isbn) {
	       this.isbn = isbn;
	   }	   
	   
	   public String getTitle() {
	       return this.title;
	   }
	   public void setTitle(String title) {
	       this.title = title;
	   }
	   
	   public String getAuthor() {
	       return this.author;
	   }
	   public void setAuthor(String author) {
	       this.author = author;
	   }

	}