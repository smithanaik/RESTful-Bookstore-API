package com.example.restfulBookStoreAPIs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restfulBookStoreAPIs.entity.Author;
import com.example.restfulBookStoreAPIs.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	AuthorRepository authorRepository;

	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}

	public Author getAuthorById(Integer id) {
		return authorRepository.findAuthorById(id);
	}

	public Author updateAuthor(Integer id, Author author) {
		return authorRepository.save(author);
	}

	public void deleteAuthor(Integer id) {
		authorRepository.deleteById(id);
	}
}
