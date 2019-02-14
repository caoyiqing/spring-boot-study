package com.cyq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyq.entity.Order;
import com.cyq.mapper.OrderMapper;
import com.cyq.response.PageData;
import com.cyq.service.GoodsService;
import com.cyq.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
		// 发生异常，使之回滚
		int i = 1 / 0;
		return orderMapper.addOrder(order);
	}

	@Override
	public Order getOrderByOrderNum(String orderNum) {
		return orderMapper.getOrderByOrderNum(orderNum);
	}

	@Override
	public PageData<Order> getOrderList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<Order> pageInfo = new PageInfo<>(orderMapper.getAllOrder());
		return new PageData<>(pageInfo.getList(), pageInfo.getTotal());
	}

}
