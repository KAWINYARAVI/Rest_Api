package com.example.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.User;


public interface Repository  extends JpaRepository<User,Integer>
{
public Optional<User>findByEmail(String username);
}
