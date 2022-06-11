package com.bruna.java.back.end.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruna.java.back.end.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	User findByCpf(String cpf);
	
	List<User> queryByNomeLike(String name);

}
