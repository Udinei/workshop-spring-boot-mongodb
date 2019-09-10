package com.udineisilva.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udineisilva.workshopmongo.domain.Post;
import com.udineisilva.workshopmongo.resources.util.URL;
import com.udineisilva.workshopmongo.services.PostService;

/**
 * Cada metodo dessa classe é considerado um endpoint
 * 
 * */
@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;

	
	// "{/id}" - complemento de /posts/id - indicando que 
	// @PathVariable - indica que o {/id} sera o parametro do metodo e que vira na url
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// @RequestParam(value="text", defaultValue="") - recebe o criterio de busca como parametro "?" (text é o nome do parametro)
	// e nao como uma variavel de url que usa "/var" por exemplo: @PathVariable String id
	@RequestMapping(value="/titlesearch",method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findBytitle(text);
		return ResponseEntity.ok().body(list);
	}	
	
}
