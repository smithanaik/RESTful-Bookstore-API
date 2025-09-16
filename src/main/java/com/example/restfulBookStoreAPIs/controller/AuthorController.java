package com.example.restfulBookStoreAPIs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.restfulBookStoreAPIs.entity.Author;
import com.example.restfulBookStoreAPIs.service.AuthorService;

@RestController
@RequestMapping("/author/v1")
public class AuthorController {
	private final AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@PostMapping("/addAuthor")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		Author savedauthor = authorService.addAuthor(author);
		return ResponseEntity.ok(savedauthor);
	}

	@GetMapping("/getAuthor/{id}")
	public ResponseEntity<Author> getAuthorByName(@PathVariable("id") Integer id) {
		final Author authorByName = authorService.getAuthorById(id);
		if (authorByName == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(authorByName);
	}

	@PutMapping("/updateAuthor/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable("id") Integer id, @RequestBody Author author) {
		Author updatedauthor = authorService.updateAuthor(id, author);
		return ResponseEntity.ok(updatedauthor);
	}

	@DeleteMapping("/deleteAuthor/{id}")
	public ResponseEntity<Author> deleteAuthor(@PathVariable("id") Integer id) {
		authorService.deleteAuthor(id);
		return ResponseEntity.ok().build();
	}
}
