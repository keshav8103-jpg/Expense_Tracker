package com.example.exp_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exp_backend.Exception.ResourceNotFoundException;
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

        //check user----------
        if(transaction.getUser()==null || 
            transaction.getUser().getUserId()==null)
        {
            throw new IllegalArgumentException("User id is required");
        }

        //chech category-----
        if(transaction.getCategory()==null || 
            transaction.getCategory().getId()==null)
        {
            throw new IllegalArgumentException("Category id is required");
        }


        Long userId = transaction.getUser().getUserId();
        Long categoryId = transaction.getCategory().getId();

        // find user --------------
        UserModel user = userRepo.findById(userId)
            .orElseThrow(() ->
                new ResourceNotFoundException
                ("User not Found with id :"+ userId)
            );

        //find category----------
        CategoryModel category = categoryRepo.findById(categoryId)
            .orElseThrow(() ->
                new ResourceNotFoundException
                ("Category not found with id :"+ categoryId)
            );    

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
        return transactionRepo.findById(id)
            .orElseThrow(() ->
            new ResourceNotFoundException
            ("Transaction not found with id :"+ id)
        );
    }

    //update transaction--------------
   
    public TransactionModel updateTransaction(Long id, TransactionModel updateTransaction)
    {
        TransactionModel transaction = transactionRepo.findById(id)
            .orElseThrow(() -> 
            new ResourceNotFoundException
            ("Transaction not found with id :"+ id)   
        );

        transaction.setTitle(updateTransaction.getTitle());
        transaction.setAmount(updateTransaction.getAmount());
        transaction.setType(updateTransaction.getType());
        transaction.setDate(updateTransaction.getDate());
        transaction.setDescription(updateTransaction.getDescription());

        // Update User
        if(updateTransaction.getUser() != null)
        {
            Long userId = updateTransaction.getUser().getUserId();

                if(userId == null)
                {
                    throw new IllegalArgumentException("User id is required");
                }

                UserModel user = userRepo.findById(userId)
                .orElseThrow(() ->
                new ResourceNotFoundException
                ("User not found with id :"+userId)
            );
            transaction.setUser(user);
        }

        // Update Category
        if(updateTransaction.getCategory() != null)
        {
            Long categoryId = updateTransaction.getCategory().getId();

            if(categoryId == null)
            {
                throw new IllegalArgumentException("Category id is required");
            }


            CategoryModel category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> 
                new ResourceNotFoundException
                ("Category not found with id :"+ categoryId)
            );

            transaction.setCategory(category);
        }

        return transactionRepo.save(transaction);
}


    //delete transaction------------------------
    public String deleteTransaction(Long id)
    {
        TransactionModel transaction=transactionRepo.findById(id)
        .orElseThrow(() ->
            new ResourceNotFoundException
            ("Transaction not found with id :"+ id)
        );

        transactionRepo.deleteById(id);
            
        return "Transaction Deleted Successfully";

    }

}
