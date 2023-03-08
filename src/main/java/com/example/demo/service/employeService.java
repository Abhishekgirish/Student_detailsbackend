package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.repos;


@Service
public class employeService {
	@Autowired
	repos repo;
	public String deleteDetails(int id) {
		repo.deleteById(id);
		return "Deleted";
	}
}
