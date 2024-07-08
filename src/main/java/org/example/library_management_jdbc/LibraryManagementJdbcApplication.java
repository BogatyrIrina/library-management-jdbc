package org.example.library_management_jdbc;

import org.example.library_management_jdbc.model.Book;
import org.example.library_management_jdbc.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementJdbcApplication.class, args);
	}
	private static final Logger logger = LoggerFactory.getLogger(LibraryManagementJdbcApplication.class);

	@Bean
	public CommandLineRunner initData(BookRepository bookRepository) {
		return args -> {
			logger.info("Adding test data...");

			Book book1 = new Book();
			book1.setTitle("To Kill a Mockingbird");
			book1.setAuthor("Harper Lee");
			book1.setPublicationYear(1960);
			bookRepository.save(book1);
			logger.info("Added book: {}", book1);

			Book book2 = new Book();
			book2.setTitle("1984");
			book2.setAuthor("George Orwell");
			book2.setPublicationYear(1949);
			bookRepository.save(book2);
			logger.info("Added book: {}", book2);

			Book book3 = new Book();
			book3.setTitle("The Great Gatsby");
			book3.setAuthor("F. Scott Fitzgerald");
			book3.setPublicationYear(1925);
			bookRepository.save(book3);
			logger.info("Added book: {}", book3);

			logger.info("Test data added successfully.");
		};
	}

}
