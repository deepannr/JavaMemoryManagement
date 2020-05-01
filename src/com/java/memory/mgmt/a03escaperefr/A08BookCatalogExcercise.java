package com.java.memory.mgmt.a03escaperefr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A08BookCatalogExcercise {

	public static void main(String[] args) {
		BookCollection bc = new BookCollection();
		
		bc.printAllBooks();
		System.out.println("---");
		// get price of book called Tom Jones in EUR
		System.out.println(bc.findBookByName("Tom Jones").getPrice().convert("EUR"));
		System.out.println("---");
		bc.printAllBooks();
	}
}

interface Book {
	int getId();
	
	String getTitle();
	
	String getAuthor();
	
	Price getPrice();
	
	String toString();
}

class BookImpl implements Book {
	private int id;
	private String title;
	private String author;
	private Price price;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public BookImpl(int id, String title, String author, Double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = new Price(price);
	}

	@Override
	public String toString() {
		return title + " by " + author;
	}

	@Override
	public Price getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = new Price(price);
	}
}

class Price {

	private Map<String, Double> rates;
	private Double value;

	public Price(Double value) {
		this.value = value;
		rates = new HashMap<String, Double>();
		rates.put("USD", 1d);
		rates.put("GBP", 0.6);
		rates.put("EUR", 0.8);
	}

	public Double convert(String toCurrency) {

		if (toCurrency.equals("USD")) {
			return value;
		} else {
//			Double conversion = rates.get("USD") / rates.get(toCurrency);
//			value = conversion * value;
			return rates.get("USD") / rates.get(toCurrency) * value;
		}
	}

	public String toString() {
		return this.value.toString();
	}

	// This class is mutable and returns whole class. So don't use this method.
	public Map<String, Double> getRates() {
		return rates;
	}
	
	public Double getRates(String currency) {
		return rates.get(currency);
	}
	
}

class BookCollection {

	private List<BookImpl> books;

	public BookCollection() {
		books = new ArrayList<BookImpl>();
		books.add(new BookImpl(1, "Don Quixote", "Miguel De Cervantes", 3.99));
		books.add(new BookImpl(2, "Pilgrim's Progress", "John Bunyan", 4.45));
		books.add(new BookImpl(3, "Robinson Crusoe", "Daniel Defoe", 3.99));
		books.add(new BookImpl(4, "Gulliver's Travels", "Jonathan Swift", 7.60));
		books.add(new BookImpl(5, "Tom Jones", "Henry Fielding", 9.99));
		books.add(new BookImpl(6, "Clarissa", "Samuel Richardson", 4.45));
		books.add(new BookImpl(7, "Dangerous Liaisons", "Pierre Choderlos De Laclos", 11.50));
		books.add(new BookImpl(8, "Emma", "Jane Austen", 3.99));
		books.add(new BookImpl(9, "Frankenstein", "Mary Shelley", 7.60));
		books.add(new BookImpl(10, "The Count of Monte Christo", "Alexandre Dumas", 3.99));
	}

	public Book findBookByName(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}

	public void printAllBooks() {
		for (BookImpl book : books) {
			System.out.println(book.getTitle() + ": " + book.getPrice());
		}
	}
}