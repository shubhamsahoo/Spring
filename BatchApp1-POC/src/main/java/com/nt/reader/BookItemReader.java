package com.nt.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class BookItemReader implements ItemReader<String> {
	private   List<String>  booksList;
	private   int count=0;

	public void setBooksList(List<String> booksList) {
		this.booksList = booksList;
	}

	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	        System.out.println("BookItemReader.read()");
	        if(count!=5)
	        return booksList.get(count++);
	        else
	        	return null;
	}

}
