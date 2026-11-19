package com.example.exp_backend.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.example.exp_backend.Model.UserModel;

@Entity
public class TransactionModel 
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    private String title;
    private Double amount;
    private String type;
    private LocalDate date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    public TransactionModel()
    {

    }

    public TransactionModel(Long id, String title, Double amount, String type, 
        LocalDate date, String description)
    {
        this.id=id;
        this.title=title;
        this.amount=amount;
        this.type=type;
        this.date=date;
        this.description=description;
    }

    public void setId(Long id)
    {
        this.id=id;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public void setAmount(Double amount)
    {
        this.amount=amount;
    }
    public void setType(String type)
    {
        this.type=type;
    } 
    public void setDate(LocalDate date)
    {
        this.date=date;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }


    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setUser(UserModel user)
    {
        this.user = user;
    }

    public UserModel getUser()
    {
        return user;
    }

    public void setCategory(CategoryModel category)
    {
        this.category = category;
    }

    public CategoryModel getCategory()
    {
        return category;
    }
}
