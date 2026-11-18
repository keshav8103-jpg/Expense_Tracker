package com.example.exp_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CategoryModel 
{
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String description;

    public CategoryModel()
    {

    }

    public CategoryModel(Long id, String name, String description)
    {
        this.id=id;
        this.name=name;
        this.description=description;
    }

    public void setId(Long id)
    {
        this.id=id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }


    public Long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    
}
