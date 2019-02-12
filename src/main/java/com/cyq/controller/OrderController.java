package com.cyq.controller;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyq.entity.Order;
import com.cyq.service.OrderService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value="新增订单", notes="新增订单")
	@ApiImplicitParam(name = "goodsId", value = "货物ID", dataType = "Long")
	@PostMapping("/addOrder")
	public Object addOrder(@NotNull(message = "货物ID不能为空") @RequestParam Long goodsId) {
		Order order = new Order();
		order.setGoodsId(goodsId);
		order.setOrderNum(UUID.randomUUID().toString().replaceAll("-", ""));
		return orderService.addOrder(order);
	}
	
	@ApiOperation(value="获取订单信息", notes="根据订单号获取订单信息")
	@ApiImplicitParam(name = "orderNum", value = "订单号", required = true, dataType = "String", paramType = "path")
	@GetMapping("/getOrderByOrderNum/{orderNum}")
	public Object getOrderByOrderNum(@NotNull(message = "订单号不能为空") @PathVariable String orderNum) {
		return orderService.getOrderByOrderNum(orderNum);
	}
	
	@ApiOperation(value="获取订单信息", notes="分页获取订单信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer"),
		@ApiImplicitParam(name = "pageSize", value = "每页多少条数据", dataType = "Integer")
    })
	@GetMapping("/getOrderList")
	public Object getOrderList(Integer pageNum, Integer pageSize) {
		if (null == pageNum) {
			pageNum = 1;
		}
		if (null == pageSize) {
			pageSize = 10;
		}
		return orderService.getOrderList(pageNum, pageSize);
	}
	

}
