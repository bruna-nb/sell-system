package com.bruna.java.back.end.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruna.java.back.end.domain.User;
import com.bruna.java.back.end.dto.UserDTO;
import com.bruna.java.back.end.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> getAll() {
		List<User> usuarios = userRepository.findAll();
		
		return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
	}
	
	public UserDTO findById(long userId) {
		Optional<User> usuario = userRepository.findById(userId);
		
		if(usuario.isPresent()) {
			return UserDTO.convert(usuario.get());
		}
		
		return null;
	}
	
	public UserDTO save (UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}
	
	public UserDTO delete(long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			userRepository.delete(user.get());
			return UserDTO.convert(user.get());
		}
		return null;
	}
	
	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		if (Objects.nonNull(user)) {
			return UserDTO.convert(user);
		}
		
		return null;
	}
	
	public List<UserDTO> queryByName(String name) {
		List<User> usuarios = userRepository.queryByNomeLike(name);
		return usuarios.stream().map(UserDTO::convert).collect(Collectors.toList());
	}
}
