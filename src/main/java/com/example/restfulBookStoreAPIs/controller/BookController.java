package com.example.restfulBookStoreAPIs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.restfulBookStoreAPIs.entity.Book;
import com.example.restfulBookStoreAPIs.service.BookService;

@RestController
@RequestMapping("/book/v1")
public class BookController {
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book savedbook = bookService.addBook(book);
		return ResponseEntity.ok(savedbook);
	}

	@GetMapping("/getBook/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
		final Book bookById = bookService.getBookById(id);
		if (bookById == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(bookById);
	}

	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
		Book updatedbook = bookService.updateBook(id, book);
		return ResponseEntity.ok(updatedbook);
	}

	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/getBooks")
	public ResponseEntity<Page<Book>> getBooks(
			@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.ok(bookService.getAllBooks(pageable));
	}

	@GetMapping("/getBooks/byTitle")
	public ResponseEntity<Page<Book>> getBooksByTitle(@RequestParam String title, Pageable pageable) {
		return ResponseEntity.ok(bookService.getBooksByTitle(title, pageable));
	}

	@GetMapping("/getBooks/byGenre")
	public ResponseEntity<Page<Book>> getBooksByGenre(@RequestParam String genre, Pageable pageable) {
		return ResponseEntity.ok(bookService.getBooksByGenre(genre, pageable));
	}

	@GetMapping("/getBooks/byAuthor")
	public ResponseEntity<Page<Book>> getBooksByAuthor(@RequestParam String authorName, Pageable pageable) {
		return ResponseEntity.ok(bookService.getBooksByAuthorName(authorName, pageable));
	}
}
