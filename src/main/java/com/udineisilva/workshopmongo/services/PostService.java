package com.udineisilva.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udineisilva.workshopmongo.domain.Post;
import com.udineisilva.workshopmongo.repository.PostRepository;
import com.udineisilva.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id){
		Optional<Post> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
	
	public List<Post> findBytitle(String text){
		// usando consulta com @Query do mongoDB
		return repo.searchTitle(text);
		
		// usando consulta simple methodquery do spring
		//return repo.findByTitleContainingIgnoreCase(text);
	}
	
	
}
