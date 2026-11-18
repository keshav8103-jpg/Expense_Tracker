package com.example.exp_backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exp_backend.Model.BudgetModel;

public interface BudgetRepo extends JpaRepository <BudgetModel, Long> 
{
    
}
