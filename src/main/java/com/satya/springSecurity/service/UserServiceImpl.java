package com.satya.springSecurity.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.satya.springSecurity.model.User;
import com.satya.springSecurity.repository.UserRepository;
import com.satya.springSecurity.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	private static final AtomicInteger count = new AtomicInteger(0);  
	@Override
	public User save(User user) {
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		long id = count.incrementAndGet();
		user.setPassword(password);
		user.setCreatedDate(new Date());
		user.setId(id);

		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return  userRepository.findByEmailIgnoreCase(email);
	}

}
