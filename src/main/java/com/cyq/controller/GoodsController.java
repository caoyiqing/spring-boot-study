package com.cyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyq.service.GoodsService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@ApiOperation(value="获取货物信息", notes="获取货物信息")
	@GetMapping("/getAllGoods")
	@ResponseBody
	public Object getAllGoods() {
		return goodsService.getAll();
	}

}
