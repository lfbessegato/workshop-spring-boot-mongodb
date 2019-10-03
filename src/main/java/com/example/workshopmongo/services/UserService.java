package com.example.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.repository.UserRepository;
import com.example.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	//Conversar com o Repository
	@Autowired //Autowired -> Injestão de dependencia dentro do Spring
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll(); //Esse método vai no BD e retorna todo os objetos do tipo User.
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	
	public void delete(String id) {
		findById(id); //Para verificar se o ID existe
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId()); //Objeto que será atualizado
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
