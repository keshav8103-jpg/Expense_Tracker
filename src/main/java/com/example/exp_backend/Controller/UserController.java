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

import com.example.exp_backend.Model.UserModel;
import com.example.exp_backend.Service.UserService;

import jakarta.validation.Valid;

@RestController 
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController 
{
    @Autowired 
    private UserService userService;

    //adddd user----------------------------
    @PostMapping
    public UserModel adduser(@Valid @RequestBody UserModel newUser)
    {
       return userService.addUser(newUser);
    } 

    //get user-------------------------------
    @GetMapping 
    public List<UserModel> getAllUser()
    {
        return userService.getAllUser();
    }

    //get user by id-----------------------------
    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    //update user-----------------------------------
    @PutMapping("/{id}")
    public UserModel updateUser(
        @PathVariable Long id, 
       @Valid @RequestBody UserModel updateUser)
    {
        return userService.updateUser(id, updateUser);
    }

    //delete user----------------------------------------

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        return userService.deleteUser(id);
    }
}
