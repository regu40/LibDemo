package com.library.libraryProject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.library.config.TestContext;
import com.library.model.Book;
import com.library.model.Search;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;
import com.library.service.LoginService;
import com.library.service.LoginServiceImpl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class})
public class AppTest {
	
	
    private UserRepository userRepository;
    
    @InjectMocks
    private LoginService service;
    
    List<User> list;
    User user;
    Book book;
	
	 @Before
	    public void setUp() {

		 userRepository = mock(UserRepository.class);
		 list = new ArrayList();
		 user = new User();
		 user.setPassword("test");
		 user.setUserName("test");
		 list.add(user);
		service = new LoginServiceImpl();
		book = new Book();
		book.setBookName("BookName");
		book.setPublish_year("2019");
	 }
	
	 @Test
	 public void validateUser()
	 {
		 String uName = "admin";
		 String password = "admin";
		 boolean status = service.validateUser(uName, password);
		 Assert.assertNotNull(status);
		 Assert.assertEquals(status, true);
	 }

	 @Test
	 public void validateUser1()
	 {
		 String uName = "user";
		 String password = "user";
		 when(userRepository.findAllByUserNameAndPassword(anyString(),anyString())).thenReturn(list);
	        
		 boolean status = service.validateUser(uName, password);
		 Assert.assertNotNull(status);
	 }
	 
	 @Test
	 public void getAllUsers()
	    {
		 service.saveUser(user);
		 List<User> user1 = service.getAllUsers();
		 Assert.assertNotNull(user1);
	    }
	 
	 
	 @Test
	 public void getBooks()
	 {
		 service.saveBook(book);
		 Search search = new Search();
		 List<Book> listBook = service.getBooks(search);
		 Assert.assertNotNull(listBook);
	 }
}
