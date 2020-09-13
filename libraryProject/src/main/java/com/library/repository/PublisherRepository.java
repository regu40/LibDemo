package com.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
