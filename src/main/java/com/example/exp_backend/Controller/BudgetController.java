package com.example.exp_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exp_backend.Model.BudgetModel;
import com.example.exp_backend.Service.BudgetService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/budgets")

public class BudgetController 
{
 
    @Autowired
    private BudgetService budgetService;

    //add budget------
    @PostMapping
    public BudgetModel addBudget(@RequestBody BudgetModel budget)
    {
        return budgetService.addBudget(budget);
    }

    // get all budgets------
    @GetMapping
    public List<BudgetModel> getAllBudget()
    {
        return budgetService.getAllBudget();
    }

    // get budget by id-----
    @GetMapping("/{id}")
    public BudgetModel getBudgetById(@PathVariable Long id)
    {
        return budgetService.getBudgetById(id);
    }

    //update budgets-----
    @PutMapping("/{id}")
    public BudgetModel updateBudget(
        @RequestBody BudgetModel budget,
        @PathVariable Long id)
    {
        return budgetService.updateBudget(budget, id);
    }
    
    //delete budget-------
    @DeleteMapping("/{id}")
    public String deleteBudget(@PathVariable Long id)
    {
        return budgetService.deleteBudget(id);
    }
}
