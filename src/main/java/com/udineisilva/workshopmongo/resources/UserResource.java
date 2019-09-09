package com.udineisilva.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udineisilva.workshopmongo.domain.User;
import com.udineisilva.workshopmongo.dto.UserDTO;
import com.udineisilva.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	// "{/id}" - complemento de /users/id - indicando que 
	// @PathVariable - indica que o {/id} sera o parametro do metodo e que vira na url
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		
		// stream - transforma list em uma coleção compativel com lambda java 8
		// x -> um elemento DTO que esta dentro de list
		// collect(collectors.toList()) retorna os objetos em uma list
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	
	/* metodo inicial de teste e resposta do browser 
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}*/
}
