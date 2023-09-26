package com.smartcontact.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartcontact.entities.User;

@Repository
public interface  UserRepository  extends CrudRepository<User,Integer>{
	
//	@Query("select u from User u where u.email = :email")
//	public User getUserByUsername(@Param("email") String email);

	Optional<User> findUserByEmail(String email);

}
