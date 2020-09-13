package com.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.model.Book; 

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByBookName(String name);
}
