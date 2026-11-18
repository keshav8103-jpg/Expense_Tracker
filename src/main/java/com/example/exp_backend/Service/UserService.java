package com.example.exp_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exp_backend.Model.UserModel;
import com.example.exp_backend.Repo.UserRepo;

@Service 
public class UserService
{

    @Autowired
    private UserRepo userRepo;

    // add user-------------------------
    public UserModel addUser(UserModel newUser)
    {
        return userRepo.save(newUser);
    }


    //user list----------------------------
    public List<UserModel> getAllUser()
    {
        return userRepo.findAll();
    }


    //user get by id-----------------------
    public UserModel getUserById(Long id)
    {
        return userRepo.findById(id).orElse(null);
    }



    //update user-------------------
    public UserModel updateUser(Long id, UserModel updateUser)
    {
        UserModel existingUser=userRepo.findById(id).orElse(null);

        if(existingUser!=null)
        {
            existingUser.setName(updateUser.getName());
            existingUser.setEmail(updateUser.getEmail());
            existingUser.setPassword(updateUser.getPassword());
            existingUser.setProfileImg(updateUser.getProfileImg());

            return userRepo.save(existingUser);
        }
        return null;
    }


    //delete user------------------
    public String deleteUser(Long id)
    {
        UserModel existingUser=userRepo.findById(id).orElse(null);

        if(existingUser!=null)
        {
            userRepo.deleteById(id);
            return "User Deleted Successfully";
        }

        return "User not found";
    }
}