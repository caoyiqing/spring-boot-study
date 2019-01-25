package com.cyq.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyq.entity.Order;
import com.cyq.service.OrderService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value="新增订单", notes="新增订单")
	@ApiImplicitParam(name = "goodsId", value = "货物ID", required = true, dataType = "Long")
	@PostMapping("/addOrder")
	public Object addOrder(@RequestParam Long goodsId) {
		Order order = new Order();
		order.setGoodsId(goodsId);
		order.setOrderNum(UUID.randomUUID().toString().replaceAll("-", ""));
		return orderService.addOrder(order);
	}

}
