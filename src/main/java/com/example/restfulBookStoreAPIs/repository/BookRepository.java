package com.example.restfulBookStoreAPIs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restfulBookStoreAPIs.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public Book findBookById(Integer id);

	Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

	Page<Book> findByGenreContainingIgnoreCase(String genre, Pageable pageable);

	Page<Book> findByAuthor_NameContainingIgnoreCase(String authorName, Pageable pageable);

}
