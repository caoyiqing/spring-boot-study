package com.cyq.service;

import com.cyq.entity.Order;
import com.cyq.response.PageData;

public interface OrderService {
	
	int addOrder(Order order);

	Order getOrderByOrderNum(String orderNum);

	PageData<Order> getOrderList(Integer pageNum, Integer pageSize);

}
