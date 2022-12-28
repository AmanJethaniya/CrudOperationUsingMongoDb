package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	@Autowired
	private ExpenseService service;
	@PostMapping
	public ResponseEntity addExpense(@RequestBody Expense expense) {
		service.addExpense(expense);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}
	@PutMapping
	public  ResponseEntity updateExpense(@RequestBody Expense expense) {
		service.updateExpense(expense);
		return ResponseEntity.ok().build();

	}
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpense() {
		return ResponseEntity.ok(service.getAllExpense());

	}
	@GetMapping("/{name}")
	public ResponseEntity getExpenseByName(@PathVariable String name) {
		return ResponseEntity.ok(service.getExpenseByName(name));

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteExpense(@PathVariable String id) {
		service.deleteExpense(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

}
