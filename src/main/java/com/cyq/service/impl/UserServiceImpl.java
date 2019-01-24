package com.cyq.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyq.mapper.UserMapper;
import com.cyq.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Map<String, Object> getUser(String id) {
		return userMapper.get(id);
	}

}
