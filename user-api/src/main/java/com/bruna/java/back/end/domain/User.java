package com.bruna.java.back.end.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bruna.java.back.end.dto.UserDTO;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Date dataCadastramento;
	
	public static User convert(UserDTO userDto) {
		User user = new User();
		user.setNome(userDto.getNome());
		user.setEndereco(userDto.getEndereco());
		user.setCpf(userDto.getCpf());
		user.setEmail(userDto.getEmail());
		user.setTelefone(userDto.getTelefone());
		user.setDataCadastramento(userDto.getDataCadastramento());
		return user;
	}
}
