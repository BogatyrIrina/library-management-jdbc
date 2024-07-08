package org.example.library_management_jdbc.service;

import org.example.library_management_jdbc.model.Book;
import org.example.library_management_jdbc.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        logger.info("Fetching all books");
        return (List<Book>) bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        logger.info("Fetching book with id: {}", id);
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        logger.info("Creating new book: {}", book);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        logger.info("Updating book with id: {}", id);
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setPublicationYear(book.getPublicationYear());
            return bookRepository.save(updatedBook);
        }
        logger.warn("Book with id {} not found", id);
        return null;
    }

    public void deleteBook(Long id) {
        logger.info("Deleting book with id: {}", id);
        bookRepository.deleteById(id);
    }
}