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

import com.example.exp_backend.Model.TransactionModel;
import com.example.exp_backend.Service.TransactionService;

@RestController 
@CrossOrigin("*")
@RequestMapping("/api/transactions")

public class TransactionController 
{

    @Autowired
    private TransactionService transactionService;

    //add transaction-----
    @PostMapping 
    public TransactionModel addTransaction(@RequestBody TransactionModel transaction)
    {
        return transactionService.addTransaction(transaction);
    }

    //get all transaction-----
    @GetMapping 
    public List<TransactionModel> getAllTransaction()
    {
        return transactionService.getAllTransaction();
    }

    //get transaction by id----
    @GetMapping("/{id}")
    public TransactionModel getTransaactionById(@PathVariable Long id)
    {
        return transactionService.getTransactionById(id);
    }

    //update transaction-----
    @PutMapping("/{id}")
    public TransactionModel updateTransaction(@PathVariable Long id, @RequestBody TransactionModel transaction)
    {
        return transactionService.updateTransaction(id,transaction);
    }

    //delete transaction-----
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id)
    {
        return transactionService.deleteTransaction(id);
    }

    
}
