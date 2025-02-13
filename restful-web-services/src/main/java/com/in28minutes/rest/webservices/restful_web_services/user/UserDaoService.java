package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static int UserCount=0;
	//JPA/Hiberante Database
	//UserDaoService talks to static list
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(++UserCount, "Anusha", LocalDate.now().minusYears(30)));
		users.add(new User(++UserCount, "Bhanu", LocalDate.now().minusYears(25)));
		users.add(new User(++UserCount, "Ramya", LocalDate.now().minusYears(20)));
		
	}
	public List<User> findAll(){
		return users;
	}
	
	public User findUser(int id){
		Predicate<? super User> prediacte = user -> user.getId().equals(id);
		return users.stream().filter(prediacte).findAny().orElse(null);
	
	}
	
	public User SaveUser(User user) {
		user.setId(++UserCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
