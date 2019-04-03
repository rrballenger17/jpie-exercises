
// Builder Pattern

public class LibraryBook {

		public String toString(){
			return "Type: " + bookType + " " + "Name: " + bookName;
		}
	
	public static class Builder {



		
		private String bookType = "Fiction"; 
		private String bookName = null;

		public Builder withBookType(final String bookType) { 
			this.bookType = bookType;
			return this;
		}

		public Builder withBookName(final String bookName) { 
			this.bookName = bookName;
			return this;
		}

		public LibraryBook build() {

			if(bookName == null){
				throw new IllegalStateException("Book must have title");
			}

			return new LibraryBook(bookType, bookName);
		} 
	}

	private final String bookType; 
	private final String bookName;

	public LibraryBook(final String bookType, final String bookName) { 
		this.bookType = bookType;
		this.bookName = bookName;
	} 

	public static void main(String args[]){

		LibraryBook.Builder builder = new LibraryBook.Builder();

		LibraryBook lb = builder
			.withBookName("Harry Potter")
			.build();

		System.out.println(lb.toString());


	}

}
