package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Models;
import com.example.demo.repository.repos;
import com.example.demo.service.employeService;

@RestController
@CrossOrigin(origins="http://localhost:3004")
public class employeeController {
	@Autowired
	repos repo;
	@Autowired
	employeService Service;
	@GetMapping("/")
	List<Models> getList(){
			return repo.findAll();
			}
	@PostMapping("/")
	public Models create(@RequestBody Models empl) {
		return repo.save(empl);
		}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		if(repo.existsById(id)) 
		{
			repo.deleteById(id);
			return "Deleted";
		}
		else 
			return "Id not existed";
	}
		@GetMapping("/{id}")
		public Optional<Models> getBookById(@PathVariable int id) {
			return repo.findById(id);
		}
		@PutMapping("/{id}")
		public String updateEmployee(@PathVariable int id,@RequestBody Models upd) {
			if(repo.existsById(id)) {
				Models t=new Models();
				t.setId(id);
				t.setName(upd.getName());
				t.setAge(upd.getAge());
				t.setDept(upd.getDept());
				t.setSalary(upd.getSalary());
				repo.save(t);
			}
			return " ";
		}
	
}
