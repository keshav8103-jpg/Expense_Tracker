package com.example.exp_backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exp_backend.Model.TransactionModel;

public interface TransactionRepo extends JpaRepository <TransactionModel, Long> 
{
    
}
