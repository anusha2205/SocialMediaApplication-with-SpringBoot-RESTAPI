package com.in28minutes.rest.webservices.restful_web_services.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {
	//@GetMapping("/helloworld")
	@RequestMapping(method = RequestMethod.GET, path="/helloworld")
	public String HelloWorld() {
		return "HelloWorld!!";
	}
	@GetMapping("/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello world");
	}
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello world "+name);
	}
}
