package com.litoos11.backUsers.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.litoos11.backUsers.model.User;
import com.litoos11.backUsers.service.UserService;
import com.litoos11.backUsers.util.RestResponse;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;
	protected ObjectMapper mapper;

	@RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) 
			throws JsonParseException, JsonMappingException, IOException {
		
		
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), 
					"Algunos campos son obligatorios");
		}
		
		this.userService.save(user);
		
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}
	
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	public List<User> getUsers() {
		return this.userService.findAll();
	}
	
	
	private boolean validate(User user) {
		boolean isValid = true;
		
		if(user.getFirstName() == null || user.getFirstName() == "") {
			isValid = false;
		}
		
		if(user.getFirstSurname() == null || user.getFirstSurname() == "") {
			isValid = false;
		}
		
		if(user.getAddress() == null || user.getAddress() == "") {
			isValid = false;
		}
		
		
		return isValid;
	}
}
