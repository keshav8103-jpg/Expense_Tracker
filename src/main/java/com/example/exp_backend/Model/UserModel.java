package com.example.exp_backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class UserModel 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false, length = 500)
    private String email;

    @Column(nullable = false)
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

    public void setId(Long userId)
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


    public Long getId()
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
