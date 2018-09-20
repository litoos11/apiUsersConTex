package com.litoos11.backUsers.service;

import java.util.List;

import com.litoos11.backUsers.model.User;

public interface UserService {

	/*
	 * Guarda o actuliza un usuair
	 * @Return usuario
	 * */
	User save(User user);
	
	/* 
	 * Recupera la lista de usuarios
	 * @Return lista de usuarios
	 * */	
	List<User> findAll();

}
