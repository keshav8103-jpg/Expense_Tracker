package com.example.exp_backend.Model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.JoinColumn;

@Entity
public class BudgetModel 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Long id;

    @NotBlank(message ="Budget name is required")
    private String name;

    @NotNull(message ="Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    @NotBlank(message ="Budget period is required")
    private String period;

    @NotNull(message ="Start date is required")
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public BudgetModel()
    {

    }
    public BudgetModel(Long id, String name, Double amount, String period, LocalDate startDate)
    {
        this.id=id;
        this.name=name;
        this.amount=amount;
        this.period=period;
        this.startDate=startDate;
    }


    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPeriod() {
        return period;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setUser(UserModel user)
    {   
        this.user = user;
    }

    public UserModel getUser()
    {
        return user;
    }
}
