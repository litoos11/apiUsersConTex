package com.litoos11.backUsers.dao;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.litoos11.backUsers.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//@SuppressWarnings("unchecked")
	//User save(User user);
	//List<User> findAll();
}
