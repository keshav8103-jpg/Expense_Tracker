package com.example.exp_backend.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exp_backend.Model.UserModel;

public interface UserRepo extends JpaRepository <UserModel, Long>
{

}