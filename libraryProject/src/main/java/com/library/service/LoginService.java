package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.Search;
import com.library.model.User;
import com.library.repository.UserRepository;

public interface LoginService {

	
	
    public boolean validateUser(String userid, String password);

    public void saveUser(User user);
    
    public List<User>getAllUsers();
    
    public User findById(long id);
    
    public User deleteById(long id);
    
    public void saveBook(Book book);
    
    public List<Book>getBooks(Search search);
    
}