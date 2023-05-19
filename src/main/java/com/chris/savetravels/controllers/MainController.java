package com.chris.savetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chris.savetravels.models.Expense;
import com.chris.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private ExpenseService expenseServ;
	
	@RequestMapping("/expenses")
	public String dashboard(Model model, @ModelAttribute("expensed") Expense expense) {
		model.addAttribute("expenses", expenseServ.allExpenses());
		return "dashboard.jsp";
	}
	
	@PostMapping("/expenses/new")
	public String newExpense(@Valid @ModelAttribute("expensed") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expenses", expenseServ.allExpenses());
			return "dashboard.jsp";
		}
		expenseServ.addExpense(expense);
		return "redirect:/expenses";
	}
	
	@RequestMapping("/expenses/{id}/edit")
	public String editExpense(@PathVariable("id") Long id, @ModelAttribute("expensed") Expense Expense, Model model) {
		model.addAttribute("expensed", expenseServ.expenseById(id));
		return "edit.jsp";
	}
	
	@PostMapping("/expenses/{id}/edit")
	public String updateExpense(@Valid @ModelAttribute("expensed")
	Expense expense, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expensed", expense);
			return "edit.jsp";
		}
		expenseServ.updateExpense(expense);
		return "redirect:/expenses";
	}
	
	@RequestMapping("/expenses/{id}")
	public String viewExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expensed", expenseServ.expenseById(id));
		return "expenseDetails.jsp";
	}
	
	@RequestMapping("/expenses/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(expenseServ.expenseById(id));
		return "redirect:/expenses";
	}

}
