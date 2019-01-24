package com.cyq.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cyq.entity.Order;

@Mapper
public interface OrderMapper {

	int addOrder(Order order);

}
