package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.Search;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository; 
	
	
    public boolean validateUser(String userid, String password) {
        boolean status= false;
        if(userid.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin"))
        {
        	status= true;
        }
        else{
        	List<User> list= (List<User>) userRepository.findAllByUserNameAndPassword(userid, password);
	       if(list != null && list.size()!=0)
	       {
	    	   status= true;
	       }
        }
        return status;
    }

    public void saveUser(User user)
    {
    	userRepository.save(user);
    }

	public List<User> getAllUsers() {
		List<User> list= (List<User>) userRepository.findAll();
		return list;
	}

	public User findById(long id) {
		User user= userRepository.findById(id);
		return user;
	}

	public User deleteById(long id) {
		User user= userRepository.findById(id);
		if(user!=null)
		userRepository.delete(id);
		return user;
	}

	public void saveBook(Book book) {
		bookRepository.save(book);	
	}

	public List<Book> getBooks(Search search) {
		List<Book> list= null;
		if(search.getName().equals("book"))
		{
			list = bookRepository.findByBookName(search.getSearch().trim());
			
		}
		/*else if(search.getName().equals("author"))
		{
			list = bookRepository.findByBookName(search.getSearch().trim());
			
		}*/
		return list;
	}
}