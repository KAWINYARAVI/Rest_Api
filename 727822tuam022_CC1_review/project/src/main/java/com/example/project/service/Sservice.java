package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.project.model.User;
import com.example.project.repository.Repository;


@Service
public class Sservice 
{


    @Autowired
    private Repository ab;
    

    public User createnewuser(@NonNull User user)
    {
        return ab.save(user);

    }

    public List<User> getAllusers()
    {
        return ab.findAll();
    }

    public Optional<User> getModelByEmail(String email)
    {
        return ab.findByEmail(email);

    
    }

    public User updateUser(@NonNull String email,@RequestBody User user)
    {
        return ab.findByEmail(email)

        .map(existingUser->
        {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            // existingUser.setContact(user.getContact());
            // existingUser.setDoctorName(user.getDoctorName());
            // existingUser.setAge(user.getAge());
            // existingUser.setDiagnosis(user.getDiagnosis());


            return ab.save(existingUser);

        }
        )
        .orElseThrow(()->new RuntimeException("user not found with this email: "+email));

    }

    public void removeUser(@NonNull Integer userId)
    {
        ab.deleteById(userId);
    }

}