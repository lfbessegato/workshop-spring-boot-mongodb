package com.example.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	//Conversar com o Repository
	@Autowired //Autowired -> Injestão de dependencia dentro do Spring
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll(); //Esse método vai no BD e retorna todo os objetos do tipo User.
	}

}
