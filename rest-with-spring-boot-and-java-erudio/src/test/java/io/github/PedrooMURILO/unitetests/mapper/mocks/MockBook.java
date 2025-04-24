package io.github.PedrooMURILO.unitetests.mapper.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.github.PedrooMURILO.data.dto.v1.BookDTO;
import io.github.PedrooMURILO.model.Book;

public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }
    
    public io.github.PedrooMURILO.data.dto.v1.BookDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookDTO> mockDTOList() {
        List<BookDTO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockDTO(i));
        }
        return books;
    }
    
    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(number.intValue());
        book.setAuthor("Some Author" + number);
        book.setLaunch_date(new Date());
        book.setPrice(25D);
        book.setTitle("Some Title" + number);
        return book;
    }

    public BookDTO mockDTO(Integer number) {
        BookDTO book = new BookDTO();
        book.setId(number.intValue());
        book.setAuthor("Some Author" + number);
        book.setLaunch_date(new Date());
        book.setPrice(25D);
        book.setTitle("Some Title" + number);
        return book;
    }

}