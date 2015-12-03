package com.thiagocardoso.tcc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thiagocardoso.tcc.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByName(String name);
	
	public User findByLogin(String login);

}
