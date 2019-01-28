package com.cyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyq.entity.Goods;
import com.cyq.service.GoodsService;

import io.swagger.annotations.ApiImplicitParam;
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
	
	@ApiOperation(value="增加货物", notes="增加货物")
	@ApiImplicitParam(name = "goods", value = "货物", dataType = "Goods")
	@PostMapping("/addGoods")
	@ResponseBody
	public Object addGoods(@Validated(value = Goods.Default.class) @RequestBody Goods goods) {
		return goodsService.addGoods(goods);
	}

}
