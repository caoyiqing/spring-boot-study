package com.cyq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyq.entity.User;
import com.cyq.mapper.UserMapper;
import com.cyq.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Map<String, Object> getUserById(String id) {
		return userMapper.get(id);
	}

	@Override
	public List<User> getUsers(Integer pageNum, Integer pageSize) {
		return userMapper.getUsers((pageNum - 1) * pageSize, pageSize);
	}

}
