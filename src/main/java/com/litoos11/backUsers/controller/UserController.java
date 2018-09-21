package com.litoos11.backUsers.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping(value = "/saveOrUpdate")
	public RestResponse saveOrUpdate(@RequestBody String userJson)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);

		if (!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Algunos campos son obligatorios");
		}

		this.userService.save(user);

		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {

		return this.userService.findAll();
	}

	@GetMapping("/getUsers/{id}")
	public Optional<User> getUserById(@PathVariable Long id) throws Exception {

		return this.userService.findById(id);
	}

	@DeleteMapping("/deleteUser/{id}") // {id:.*} opcional id
	public RestResponse deleteUser(@PathVariable Long id) throws Exception {

		boolean existe;		
		existe = this.userService.existeUser(id);

		if (existe) {
			this.userService.deleteUser(id);
			return new RestResponse(HttpStatus.OK.value(), "Operación exitosa!");
		} else {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "No existe el usuario :-(");
		}

	}

	private boolean validate(User user) {
		boolean isValid = true;

		if (user.getFirstName() == null || user.getFirstName() == "") {
			isValid = false;
		}

		if (user.getFirstSurname() == null || user.getFirstSurname() == "") {
			isValid = false;
		}

		if (user.getAddress() == null || user.getAddress() == "") {
			isValid = false;
		}

		return isValid;
	}
}
