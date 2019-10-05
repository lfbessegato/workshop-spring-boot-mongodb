package com.example.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.repository.PostRepository;
import com.example.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	//Conversar com o Repository
	@Autowired //Autowired -> Injestão de dependencia dentro do Spring
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	//Montagem do método para Encontrar o título
	public List<Post> findByTitle(String text){
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
}
