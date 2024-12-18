package com.example.demo11.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo11.dto.ExpenseDto;
import com.example.demo11.model.Expense;
import com.example.demo11.model.ExpenseRepository;
import com.example.demo11.model.User;
import com.example.demo11.model.UserRepos;
import com.example.demo11.service.ExpenseService;


import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class HelloWorldController {

	@Autowired
	private UserRepos userRepo;

	@Autowired
	private ExpenseRepository expesneRepo;

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/hello")
	public String start() {
		System.out.println("From controller..");
		return "Hello, this is a message from the API!";
	}

	@GetMapping("/users/view")
	public List<User> getAllUsers(Model model) {
		System.out.println("Getting all users");
		// get all users from database
		List<User> users = userRepo.findAll();

		// end of database call
		model.addAttribute("us", users);
		return users;
	}

	@PostMapping("/users/add")
	public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response) {
		System.out.println("ADD user");
		String newName = newuser.get("name");
		String newPwd = newuser.get("password");
		int newSize = Integer.parseInt(newuser.get("size"));
		userRepo.save(new User(newName, newPwd, newSize));
		response.setStatus(201);
		return "users/addedUser";
	}

	@PostMapping("/addexpense")
	public ResponseEntity<Expense> createExpense(@RequestBody ExpenseDto expenseDTO) {
		Expense savedExpense = expenseService.saveExpense(expenseDTO);
		return ResponseEntity.ok(savedExpense);
	}

	@GetMapping("/allexpense")
	public ResponseEntity<List<Expense>> getAllExpenses() {
		return ResponseEntity.status(HttpStatus.OK).body(expenseService.getAllExpenses());
	}

	@GetMapping("/expensebydate/{Date}")
	public ResponseEntity<List<Expense>> getExpensesByBrand(@PathVariable LocalDate Date) {
		return ResponseEntity.ok(expenseService.getExpensesByDate(Date));
	}

	@PutMapping("/update-by-criteria")
	public ResponseEntity<Expense> updateExpense(@RequestParam String expenseFrom, @RequestParam LocalDate date,
			@RequestParam String expenseName, @RequestBody ExpenseDto expenseDTO) {
		Expense updatedExpense = expenseService.updateExpense(expenseFrom, date, expenseName, expenseDTO);
		return ResponseEntity.ok(updatedExpense);
	}

	@DeleteMapping("/delete-by-criteria")
	public ResponseEntity<String> deleteExpense(@RequestParam String expenseFrom, @RequestParam LocalDate date,
			@RequestParam String expenseName) {
		expenseService.deleteExpense(expenseFrom, date, expenseName);
		return ResponseEntity.ok("Expense deleted successfully for expenseFrom=" + expenseFrom + ", date=" + date
				+ ", expenseName=" + expenseName);
	}
}