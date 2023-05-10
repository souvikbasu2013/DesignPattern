package com.java8;

import java.util.ArrayList;
import java.util.List;


// creating a immutable class with collection that requires a deep copy to keep the immutability intact in case of collection pass by value

final class Trade{

	private final double value;
	private final String tradeType;
	private final String system;
	private final List<String> books;
	
	public List<String> getBooks() {
		return books;
	}

	public Trade(double value, String tradeType, String system, List<String> books) {
		super();
		this.value = value;
		this.tradeType = tradeType;
		this.system = system;
		//this.books = books;
		List<String> booksTemp = new ArrayList<String>();
		for(String s: books)
			booksTemp.add(s);
		this.books = booksTemp;
	}
	
	public double getValue() {
		return value;
	}
	public String getTradeType() {
		return tradeType;
	}
	public String getSystem() {
		return system;
	}
	@Override
	public String toString() {
		return "Trade [value=" + value + ", tradeType=" + tradeType + ", system=" + system + ", books=" + books + "]";
	}
	

	
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> bookList = new ArrayList<String>();
		bookList.add("A1");
		bookList.add("A2");
		Trade tr = new Trade(32.8,"ABC", "xyz",bookList);
		System.out.println(tr);
		System.out.println(bookList);
		bookList.add("A3");
		System.out.println(tr);
		System.out.println(bookList);
		
		
		
	}

}
