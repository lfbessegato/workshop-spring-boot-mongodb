package com.example.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//Tem que respeitar os nomes para o spring montar automático.
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	

}
