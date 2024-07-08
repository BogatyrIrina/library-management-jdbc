package org.example.library_management_jdbc.repository;

import org.example.library_management_jdbc.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
