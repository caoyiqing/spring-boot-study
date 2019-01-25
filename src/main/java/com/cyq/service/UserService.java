package com.cyq.service;

import java.util.List;
import java.util.Map;

import com.cyq.entity.User;

public interface UserService {
	
	Map<String, Object> getUserById(String id);

	List<User> getUsers(Integer pageNum, Integer pageSize);

}
