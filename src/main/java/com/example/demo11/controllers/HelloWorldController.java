package com.example.demo11.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo11.model.User;
import com.example.demo11.model.UserRepos;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class HelloWorldController {

    @Autowired
    private UserRepos userRepo;
	
	@GetMapping("/hello")
	public String start(){
		System.out.println("From controller..");
		return "Hello, this is a message from the API!";
	}
	  @GetMapping("/users/view")
	    public List<User> getAllUsers(Model model){
	        System.out.println("Getting all users");
	        // get all users from database
	        List<User> users = userRepo.findAll();
	        
	        // end of database call
	        model.addAttribute("us", users);
	        return users;
	    }

	    @PostMapping("/users/add")
	    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
	        System.out.println("ADD user");
	        String newName = newuser.get("name");
	        String newPwd = newuser.get("password");
	        int newSize = Integer.parseInt(newuser.get("size"));
	        userRepo.save(new User(newName,newPwd,newSize));
	        response.setStatus(201);
	        return "users/addedUser";
	    }
}