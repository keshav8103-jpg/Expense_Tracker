package com.example.exp_backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exp_backend.Model.CategoryModel;

public interface CategoryRepo extends JpaRepository <CategoryModel, Long> 
{
    
}
