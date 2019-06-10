package com.satya.springSecurity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.satya.springSecurity.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByEmailIgnoreCase(String username);

}
