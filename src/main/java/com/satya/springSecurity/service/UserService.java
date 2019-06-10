package com.satya.springSecurity.service;

import java.util.List;

import com.satya.springSecurity.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
