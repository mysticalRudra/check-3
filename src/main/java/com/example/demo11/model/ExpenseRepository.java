package com.example.demo11.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	List<Expense> findByDate(LocalDate date);

	Optional<Expense> findByExpenseFromAndDateAndExpenseName(String expenseFrom, LocalDate date, String expenseName);

	void deleteByExpenseFromAndDateAndExpenseName(String expenseFrom, LocalDate date, String expenseName);

	boolean existsByExpenseFromAndDateAndExpenseName(String expenseFrom, LocalDate date, String expenseName);

}
