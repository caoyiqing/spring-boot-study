package com.cyq.service;

import java.util.List;

import com.cyq.entity.Goods;

public interface GoodsService {
	
	int addGoods(Goods goods);
	
	List<Goods> getAll();
	
	int updateStock(Long id, int stock);

}
