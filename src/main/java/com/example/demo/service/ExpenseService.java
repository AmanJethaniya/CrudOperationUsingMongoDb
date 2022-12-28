package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository repository;
	

	public void addExpense(Expense expense) {
		repository.insert(expense);

	}


	public void updateExpense(Expense expense) {
		Optional<Expense> savedExpense = repository.findById(expense.getId());
		if(savedExpense.isPresent())
		{
			savedExpense.get().setExpenseAmount(expense.getExpenseAmount());
			savedExpense.get().setExpenseCategory(expense.getExpenseCategory());
			savedExpense.get().setExpenseName(expense.getExpenseName());
		} else {
			throw new RuntimeException("Given object is not present in the db hence can not be updated");
		}
		repository.save(savedExpense.get());

	}

	public List<Expense> getAllExpense() {
		return repository.findAll();
		

	}

	public Optional<Expense> getExpenseByName(String expenseName) {
		return repository.findByExpenseName(expenseName);
		

	}

	public void deleteExpense(String id) {
		repository.deleteById(id);
		

	}

}
