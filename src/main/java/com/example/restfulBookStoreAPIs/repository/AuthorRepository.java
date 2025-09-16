package com.example.restfulBookStoreAPIs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restfulBookStoreAPIs.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	public Author findAuthorById(Integer id);
}
