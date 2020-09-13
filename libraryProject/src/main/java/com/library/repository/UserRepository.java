package com.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.model.User;


public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findAllByUserNameAndPassword(String userid, String password);
	public User findById(long id);
}
