package com.bruna.java.back.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bruna.java.back.end.dto.UserDTO;
import com.bruna.java.back.end.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/")
	public String getMensagem() {
		return "Spring boot is working!";
	}
	
	@GetMapping("/user")
	public List<UserDTO> getUsers() {
		return userService.getAll();
	
	}
	
	@GetMapping("/user/{id}")
	UserDTO findById(@PathVariable long id) {
		return userService.findById(id);
	}
	
	@PostMapping("/user")
	UserDTO newUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@GetMapping("/user/cpf/{cpf}")
	UserDTO findByCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);
	}
	
	
}
