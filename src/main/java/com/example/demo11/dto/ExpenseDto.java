package com.example.demo11.dto;

import java.time.LocalDate;

public class ExpenseDto {
    private String expenseName;
    private Double expenseAmount;
    private String comment;
    private String expenseFrom;
    private LocalDate date;

    // Getters and Setters
    public String getExpenseName() {
        return expenseName;
    }
    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }
    public Double getExpenseAmount() {
        return expenseAmount;
    }
    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getExpenseFrom() {
        return expenseFrom;
    }
    public void setExpenseFrom(String expenseFrom) {
        this.expenseFrom = expenseFrom;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
