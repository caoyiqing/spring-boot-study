package com.cyq.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@ApiImplicitParam(name = "order", value = "Order实体类", required = true, dataType = "Order")
	@PostMapping("/addOrder")
	public Object addOrder(@RequestBody Order order) {
		order.setOrderNum(UUID.randomUUID().toString().replaceAll("-", ""));
		return orderService.addOrder(order);
	}

}
