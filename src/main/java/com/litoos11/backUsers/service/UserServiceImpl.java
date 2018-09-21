package com.litoos11.backUsers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litoos11.backUsers.dao.UserRepository;
import com.litoos11.backUsers.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	protected UserRepository userRepository;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
	}

	@Override
	public Optional<User> findById(Long userId) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(userId);
	}

	@Override
	public boolean existeUser(Long id) {
		// TODO Auto-generated method stub
		return this.userRepository.existsById(id);
	}
}
