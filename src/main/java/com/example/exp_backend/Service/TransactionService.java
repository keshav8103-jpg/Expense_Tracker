package com.example.exp_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exp_backend.Model.TransactionModel;
import com.example.exp_backend.Repo.TransactionRepo;

@Service
public class TransactionService 
{
    @Autowired 
    private TransactionRepo transactionRepo;


    //addd transaction------------------
    public TransactionModel addTransaction(TransactionModel transaction)
    {
        return transactionRepo.save(transaction);
    }

    //get all transaction---------------
    public List<TransactionModel> getAllTransaction()
    {
        return transactionRepo.findAll();  
    }

    //get transaction by id-------------
    public TransactionModel getTransactionById(Long id)
    {
        return transactionRepo.findById(id).orElse(null);
    }

    //update transaction--------------
    public TransactionModel updateTransaction(Long id,TransactionModel updateTransaction)
    {
        TransactionModel transaction=transactionRepo.findById(id).orElse(null);

        if(transaction!=null)
        {
            transaction.setTitle(updateTransaction.getTitle());
            transaction.setAmount(updateTransaction.getAmount());
            transaction.setType(updateTransaction.getType());
            transaction.setDate(updateTransaction.getDate());
            transaction.setDescription(updateTransaction.getDescription());

            return transactionRepo.save(transaction);
        }

        return null;
    }

    //delete transaction------------------------
    public String deleteTransaction(Long id)
    {
        TransactionModel transaction=transactionRepo.findById(id).orElse(null);

        if(transaction!=null)
        {
            transactionRepo.deleteById(id);
            
            return "Transaction Deleted Successfully";
        }
        
        return "Transaction Not Found";

    }

}
