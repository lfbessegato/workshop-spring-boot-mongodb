package com.example.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.resources.util.URL;
import com.example.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {

		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj); // Retorna o objeto que buscou
	}	
	
	@RequestMapping(value="/titlesearch", method = RequestMethod.GET)
	//@RequestParam -> Para inserir como parâmetro na URL
	//(value=text) -> Para identificar ao parametro a palavra text, antes de inserir as palavra do Título
	public ResponseEntity<List<Post>> findByTitleId(@RequestParam(value="text", defaultValue="") String text) {
		
		//Para decodificar o texto ("bom%20dia")
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);

		return ResponseEntity.ok().body(list); // Retorna o objeto que buscou para o título
	}	
}
