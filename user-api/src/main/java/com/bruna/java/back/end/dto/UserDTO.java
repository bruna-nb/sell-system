package com.bruna.java.back.end.dto;

import java.util.Date;

import com.bruna.java.back.end.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Date dataCadastramento;
	
	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome(user.getNome());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setDataCadastramento(user.getDataCadastramento());
		return userDTO;
	}

}
