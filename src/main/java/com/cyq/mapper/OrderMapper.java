package com.cyq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cyq.entity.Order;

@Mapper
public interface OrderMapper {

	List<Order> getAllOrder();
	
	int addOrder(Order order);

	Order getOrderByOrderNum(String orderNum);

}
