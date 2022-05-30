package com.bruna.java.back.end.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruna.java.back.end.dto.UserDTO;

@RestController
public class UserController {
	public static List<UserDTO> usuarios = new ArrayList<UserDTO>();
	
	@GetMapping("/")
	public String getMensagem() {
		return "Spring boot is working!";
	}
	
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return usuarios;
	}
	
	@PostConstruct //@PostConstruct faz com que este método seja executado logo depois que o container inicializa a classe UserController.
	public void initiateList() {
		UserDTO userDto1 = new UserDTO();
		userDto1.setNome("Eduardo");
		userDto1.setCpf("13729004034");
		userDto1.setEndereco("Rua a exemplo");
		userDto1.setEmail("eduardo@email.com");
		userDto1.setTelefone("790973981");
		userDto1.setDataCadastramento(new Date());
		
		UserDTO userDto2 = new UserDTO();
		userDto2.setNome("Luiz");
		userDto2.setCpf("58594208030");
		userDto2.setEndereco("Rua b exemplo");
		userDto2.setEmail("luiz@email.com");
		userDto2.setTelefone("790973981");
		userDto2.setDataCadastramento(new Date());
		
		UserDTO userDto3 = new UserDTO();
		userDto3.setNome("Bruna");
		userDto3.setCpf("53378045027");
		userDto3.setEndereco("Rua c exemplo");
		userDto3.setEmail("bruna@email.com");
		userDto3.setTelefone("790973981");
		userDto3.setDataCadastramento(new Date());
		
		usuarios.add(userDto1);
		usuarios.add(userDto2);
		usuarios.add(userDto3);
	}
}
