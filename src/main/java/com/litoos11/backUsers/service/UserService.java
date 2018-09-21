package com.litoos11.backUsers.service;

import java.util.List;
import java.util.Optional;

import com.litoos11.backUsers.model.User;

public interface UserService {

	/*
	 * Guarda o actualiza un usuario
	 * @Return usuario
	 * */
	User save(User user);
	
	/* 
	 * Recupera la lista de usuarios
	 * @Return lista de usuarios
	 * */	
	List<User> findAll();

	/* 
	 * Elimina un usuario de la lista de usuarios
	 * */	
	void deleteUser(Long userId);

	/* 
	 * Recupera un usuario de la lista de usuarios
	 * @Return Usuarios
	 * */
	Optional<User> findById(Long userId);

	boolean existeUser(Long id);

}
