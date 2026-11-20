package com.example.exp_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity 
public class UserModel 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userId;

    @NotBlank(message="Name is Required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private String profileImg;   

    public UserModel()
    {

    }

    public UserModel(Long userId, String name, String email, String password, String profileImg)
    {
        this.userId=userId;
        this.name=name;
        this.email=email;
        this.password=password;
        this.profileImg=profileImg;
    }

    public void setUserId(Long userId)
    {
        this.userId=userId;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public void setProfileImg(String profileImg)
    {
        this.profileImg=profileImg;
    }


    public Long getUserId()
    {
        return userId;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public String getProfileImg()
    {
        return profileImg;
    }

}
