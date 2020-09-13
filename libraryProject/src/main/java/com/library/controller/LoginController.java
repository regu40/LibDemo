package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.library.model.Book;
import com.library.model.Search;
import com.library.model.User;
import com.library.service.LoginService;

//import io.swagger.annotations.ApiOperation;

@Controller
//@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model,HttpSession session){
    	if(session != null)
    	session.invalidate();
        return  "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showAdminPage(ModelMap model, @RequestParam String name, @RequestParam String password,HttpSession session){
        boolean isValidUser = service.validateUser(name, password);
        if (!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
       session.setAttribute("userName", name);
        model.put("name", name);
        model.put("password", password);

        return "mainPage";
    }
    
    @RequestMapping(value="/addUser", method = RequestMethod.GET)
    public ModelAndView showaddUserPage(HttpSession session)
    {
    	ModelAndView mav = new ModelAndView("addUser");
    	mav.addObject(new User());
    	return mav;
    }

    @RequestMapping(value="/submitUser", method = RequestMethod.POST)
    public String submitUserDetails(@ModelAttribute("user") User user,HttpSession session)
    {
    	System.out.println("user>> "+ user.getUserName());
    	service.saveUser(user);
    	return "mainPage";
    }
    
    @RequestMapping(value="/viewUser", method = RequestMethod.GET)
    public ModelAndView viewUser(HttpSession session)
    {
    	List<User> list = service.getAllUsers();
    	ModelAndView mav = new ModelAndView("viewUsers");
    	mav.addObject("user",list);
    	return mav;
    }
    
    @RequestMapping(value="/editUser", method = RequestMethod.GET)
    public ModelAndView editUserPage(@RequestParam("id") long id,HttpSession session)
    {
    	User user = service.findById(id);
    	ModelAndView mav = new ModelAndView("addUser");
    	mav.addObject("user",user);
    	return mav;
    }
    
    @RequestMapping(value="/deleteUser", method = RequestMethod.GET)
    public String delteUser(ModelMap model,@RequestParam("id") long id,HttpSession session)
    {
    	User user = service.deleteById(id);
    	 model.put("errorMessage", "Invalid Credentials");
    	return "redirect:/viewUser";
    }
    
    @RequestMapping(value="/backAction", method = RequestMethod.POST)
    public String backAction(HttpSession session)
    {
    	return "mainPage";
    }

    @RequestMapping(value="/addBooks", method = RequestMethod.GET)
    public ModelAndView showaddBookPage(HttpSession session)
    {
    	ModelAndView mav = new ModelAndView("addBooks");
    	mav.addObject(new Book());
    	return mav;
    }
    
    @RequestMapping(value="/submitBook", method = RequestMethod.POST)
    public String submitBook(@ModelAttribute("book") Book book,HttpSession session)
    {
    	System.out.println("dd> "+book.getStatus());
    	service.saveBook(book);
    	return "mainPage";
    }


    @RequestMapping(value="/viewBooks", method = RequestMethod.GET)
    public ModelAndView viewBooks(HttpSession session)
    {
    	ModelAndView mav = new ModelAndView("viewBooks");
    	mav.addObject(new Search());
    	return mav;
    }
    
    @RequestMapping(value="/search", method = RequestMethod.POST)
   public ModelAndView searchList(@ModelAttribute("search") Search search,HttpSession session)
    {
    	List<Book> list = service.getBooks(search);
    	ModelAndView mav = new ModelAndView("viewBookList");
    	mav.addObject("book",list);
    	return mav;
    }
}