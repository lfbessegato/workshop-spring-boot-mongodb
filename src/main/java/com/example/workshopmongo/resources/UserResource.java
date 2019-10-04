package com.example.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)

	// ResponseEnity -> Encapsular o retorno com possíveis cabeçalhos, erros
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = service.findAll();

		/*
		 * Converter para uma lista UserDTO a partir de uma Lista de User.
		 * 
		 */

		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto); // Corpo da resposta
	}
	

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {

		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj)); // Corpo da resposta
	}
	
	//Método Insert
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {

		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		//Colocar um cabeçalho para Inserção
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build(); // Corpo da resposta
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {

		service.delete(id);
		return ResponseEntity.noContent().build(); // Retorna código 204
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {

		User obj = service.fromDTO(objDto);
		obj.setId(id); //Para garantir que o id é o que veio na requisição
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build(); // Retorna código 204
	}
	
	//Retornando os posts do Usuário
	@RequestMapping(value="/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {

		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts()); // Retorna a lista de Posts
	}
}
