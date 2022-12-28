package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
	Optional<Expense> findByExpenseName(String expenseName);
	

}