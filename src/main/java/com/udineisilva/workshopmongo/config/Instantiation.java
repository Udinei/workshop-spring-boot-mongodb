package com.udineisilva.workshopmongo.config;





import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.udineisilva.workshopmongo.domain.Post;
import com.udineisilva.workshopmongo.domain.User;
import com.udineisilva.workshopmongo.repository.PostRepository;
import com.udineisilva.workshopmongo.repository.UserRepository;

/* Essa classe inicia a carga inicial de testes do sistema */
@Configuration
public  class Instantiation implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		// limpa documentos do banco de dados
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		/*------ User ------*/
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
			
		/*------ Post ------*/
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}
	
	

}
