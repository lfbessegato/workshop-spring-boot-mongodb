package com.example.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//Agora pode ser o nome quiser
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	//Tem que respeitar os nomes para o spring montar automático.
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	

}
