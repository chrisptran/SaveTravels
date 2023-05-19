package com.chris.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.savetravels.models.Expense;
import com.chris.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepo;
	
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}
	
	public Expense addExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public Expense expenseById(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}
	
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public void deleteExpense(Expense expense) {
		expenseRepo.delete(expense);
	}

}
