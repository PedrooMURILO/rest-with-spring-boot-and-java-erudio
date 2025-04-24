package io.github.PedrooMURILO.repository;

import io.github.PedrooMURILO.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
