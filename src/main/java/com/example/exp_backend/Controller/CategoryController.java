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

import com.example.exp_backend.Model.CategoryModel;
import com.example.exp_backend.Service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categories")
public class CategoryController 
{
    
    @Autowired 
    private CategoryService categoryService;
    

    @PostMapping 
    public CategoryModel addCategory(@RequestBody CategoryModel category)
    {
        return categoryService.addCategory(category);
    }

    @GetMapping 
    public List<CategoryModel> getAllCategory()
    {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryModel getCategoryById(@PathVariable Long id)
    {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryModel updateCategory(
        @RequestBody CategoryModel category
        ,@PathVariable Long id)
    {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id)
    {
        return categoryService.deleteCategory(id);
    }
}
