package com.example.restfulBookStoreAPIs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restfulBookStoreAPIs.entity.Author;
import com.example.restfulBookStoreAPIs.entity.Book;
import com.example.restfulBookStoreAPIs.repository.AuthorRepository;
import com.example.restfulBookStoreAPIs.repository.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	@Autowired
	public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public Book addBook(Book book) {
		Author author = authorRepository.findById(book.getAuthor().getId())
				.orElseThrow(() -> new RuntimeException("Author not found"));
		book.setAuthor(author);
		return bookRepository.save(book);
	}

	public Book getBookById(Integer id) {
		return bookRepository.findBookById(id);
	}

	public Book updateBook(Integer id, Book book) {
		return bookRepository.save(book);
	}

	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

	public Page<Book> getAllBooks(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	public Page<Book> getBooksByTitle(String title, Pageable pageable) {
		return bookRepository.findByTitleContainingIgnoreCase(title, pageable);
	}

	public Page<Book> getBooksByGenre(String genre, Pageable pageable) {
		return bookRepository.findByGenreContainingIgnoreCase(genre, pageable);
	}

	public Page<Book> getBooksByAuthorName(String authorName, Pageable pageable) {
		return bookRepository.findByAuthor_NameContainingIgnoreCase(authorName, pageable);
	}
}
