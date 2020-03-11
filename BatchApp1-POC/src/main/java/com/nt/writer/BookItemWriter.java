package com.nt.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class BookItemWriter implements ItemWriter<String> {

	public void write(List<? extends String> booksList) throws Exception {
		System.out.println("BookItemWriter.write(-)");
		for(String  book:booksList) {
			System.out.println(book);
		}
		
	}

}
