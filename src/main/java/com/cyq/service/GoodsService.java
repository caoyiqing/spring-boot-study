package com.cyq.service;

import java.util.List;

import com.cyq.entity.Goods;

public interface GoodsService {
	
	List<Goods> getAll();
	
	int updateStock(Long id, int stock);

}
