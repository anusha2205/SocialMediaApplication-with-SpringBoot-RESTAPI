package com.in28minutes.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController //REST API
public class UserResource {
	private UserDaoService service;
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	//GET /users
	@GetMapping("/users")
	public List<User> RetriveAllUsers(){
		return service.findAll();
		
	}
	//GET /users/{user}
	@GetMapping("/users/{id}")
	public User RetriveUser(@PathVariable int id){
		User user =  service.findUser(id);
		
		if(user == null) {
			throw new UserNotFoundException("id:"+id);
		}
		return user;
	}
	//Post
	@PostMapping("/users")
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
		User saveduser =service.SaveUser(user);
		
		URI location= ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}

}
