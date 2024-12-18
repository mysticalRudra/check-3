package com.example.demo11.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo11.dto.ExpenseDto;
import com.example.demo11.model.Expense;
import com.example.demo11.model.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(ExpenseDto expenseDTO) {
     
        Expense expense = new Expense();
        expense.setExpenseName(expenseDTO.getExpenseName());
        expense.setExpenseAmount(expenseDTO.getExpenseAmount());
        expense.setComment(expenseDTO.getComment());
        expense.setExpenseFrom(expenseDTO.getExpenseFrom());
        expense.setDate(expenseDTO.getDate());
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

	public List<Expense> getExpensesByDate(LocalDate date) {
		return expenseRepository.findByDate(date);
	}
  
    @Transactional
    public Expense updateExpense(String expenseFrom, LocalDate date, String expenseName, ExpenseDto expenseDTO) {
        Optional<Expense> optionalExpense = expenseRepository.findByExpenseFromAndDateAndExpenseName(expenseFrom, date, expenseName);

        if (optionalExpense.isPresent()) {
            Expense expense = optionalExpense.get();
            expense.setExpenseName(expenseDTO.getExpenseName());
            expense.setExpenseAmount(expenseDTO.getExpenseAmount());
            expense.setComment(expenseDTO.getComment());
            expense.setExpenseFrom(expenseDTO.getExpenseFrom());
            expense.setDate(expenseDTO.getDate());
            return expenseRepository.save(expense);
        } else {
            throw new RuntimeException("Expense not found with expenseFrom=" + expenseFrom + ", date=" + date + ", expenseName=" + expenseName);
        }
    }

    @Transactional
    public void deleteExpense(String expenseFrom, LocalDate date, String expenseName) {
        if (expenseRepository.existsByExpenseFromAndDateAndExpenseName(expenseFrom, date, expenseName)) {
            expenseRepository.deleteByExpenseFromAndDateAndExpenseName(expenseFrom, date, expenseName);
        } else {
            throw new RuntimeException("Expense not found with expenseFrom=" + expenseFrom + ", date=" + date + ", expenseName=" + expenseName);
        }
    }
}
