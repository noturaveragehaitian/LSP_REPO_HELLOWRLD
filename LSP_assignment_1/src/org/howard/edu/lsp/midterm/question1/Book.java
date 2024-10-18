package org.howard.edu.lsp.midterm.question1;

public class Book {
	public String title;
	public String author;
	public String ISBN;
	public int yearPublished;
	
	// book constructor. https://www.w3schools.com/java/java_constructors.asp
	public Book (String title, String author, String ISBN, int yearPublished) {		
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.yearPublished = yearPublished;
	}
	
	// Overriding toString() to reflect system output (https://stackoverflow.com/questions/3615721/how-to-use-the-tostring-method-in-java)
	@Override
	public String toString() {
		return "Title: " + this.title + ", Author: " + this.author + ", ISBN: " + this.ISBN + "Year Published: " + this.yearPublished; 
	}
	
	// Overriding boolean equation for books with same authors/ISBNs. (chatGPT)
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return ISBN.equals(book.ISBN) && author.equals(book.author);
	}
}

