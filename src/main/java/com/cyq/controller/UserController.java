package com.cyq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cyq.entity.User;
import com.cyq.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value="获取用户信息", notes="根据ID获取用户信息")
	@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/user/getUserById/{id}")
	public Object getUserById(@PathVariable String id) {
		return userService.getUserById(id);
	}
	
	
	@ApiOperation(value="获取用户信息", notes="分页获取用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "path"),
		@ApiImplicitParam(name = "pageSize", value = "每页多少条", dataType = "Integer", paramType = "path")
    })
	@GetMapping("/user/getUsers/{pageNum}/{pageSize}")
	public List<User> getUsers(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
		if (null == pageNum) {
			pageNum = 1;
		}
		if (null == pageSize) {
			pageSize = 10;
		}
		return userService.getUsers(pageNum, pageSize);
	}

}
