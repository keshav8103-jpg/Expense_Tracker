package com.example.exp_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exp_backend.Model.CategoryModel;
import com.example.exp_backend.Model.TransactionModel;
import com.example.exp_backend.Model.UserModel;
import com.example.exp_backend.Repo.CategoryRepo;
import com.example.exp_backend.Repo.TransactionRepo;
import com.example.exp_backend.Repo.UserRepo;

@Service
public class TransactionService 
{
    @Autowired 
    private TransactionRepo transactionRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    //addd transaction------------------
    public TransactionModel addTransaction(TransactionModel transaction)
    {
        Long userId = transaction.getUser().getUserId();
        Long categoryId = transaction.getCategory().getId();

        UserModel user = userRepo.findById(userId).orElse(null);
        CategoryModel category = categoryRepo.findById(categoryId).orElse(null);

        if(user==null || category==null)
        {
            return null;
        }
        transaction.setUser(user);
        transaction.setCategory(category);

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

            if (updateTransaction.getUser() != null) 
            {
            Long userId = updateTransaction.getUser().getUserId();
            UserModel user = userRepo.findById(userId).orElse(null);
            transaction.setUser(user);
            }
            if(updateTransaction.getCategory() != null)
            {
                Long categoryId = updateTransaction.getCategory().getId();

                CategoryModel category = categoryRepo.findById(categoryId).orElse(null);

                if(category != null)
                {
                transaction.setCategory(category);
                }
            }

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
