package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Models;

@Repository

public interface repos extends JpaRepository<Models,Integer>{
	
}
