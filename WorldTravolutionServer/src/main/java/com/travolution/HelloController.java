package com.travolution;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/greetings")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET, produces = { "text/plain" })
	public String index() {
		return "Greetings from Spring Boot! Welcome!!";
	}
	
}
