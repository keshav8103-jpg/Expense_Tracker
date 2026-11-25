package com.example.exp_backend.Exception;

public class ResourceNotFoundException extends RuntimeException
{
    //constructor exception ke sath messg dega
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
    
}
