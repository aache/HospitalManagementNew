package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.services.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService doctorService; 
	
	@PostMapping("api/addDoctor")
	public void addNewDoctor(@RequestBody Doctor doctor) {
		doctorService.saveDoctor(doctor); 
	}
}
