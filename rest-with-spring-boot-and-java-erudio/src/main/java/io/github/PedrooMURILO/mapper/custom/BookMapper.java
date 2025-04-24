package io.github.PedrooMURILO.mapper.custom;

import io.github.PedrooMURILO.data.dto.v1.BookDTO;
import io.github.PedrooMURILO.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public BookDTO convertEntityToDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        dto.setTitle(book.getTitle());
        dto.setLaunch_date(book.getLaunch_date());
        return dto;
    }

    public Book convertDTOToEntity(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setTitle(dto.getTitle());
        book.setLaunch_date(dto.getLaunch_date());
        return book;
    }
}
