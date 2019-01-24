package com.cyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyq.entity.Order;
import com.cyq.mapper.OrderMapper;
import com.cyq.service.GoodsService;
import com.cyq.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private GoodsService goodsService;

	@Override
	@Transactional
	public int addOrder(Order order) {
		goodsService.updateStock(order.getGoodsId(), -1);
		return orderMapper.addOrder(order);
	}

}
