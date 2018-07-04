package com.klayrocha.helpdesk.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klayrocha.helpdesk.api.entity.User;
import com.klayrocha.helpdesk.api.repository.UserRepository;
import com.klayrocha.helpdesk.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public Page<User> findAll(int page, int count) {
		// TODO Auto-generated method stub
		return userRepository.findAll((Pageable) new PageRequest(page, count));
	}

}
