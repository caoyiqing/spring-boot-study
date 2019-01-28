package com.cyq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyq.entity.Goods;
import com.cyq.mapper.GoodsMapper;
import com.cyq.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public int addGoods(Goods goods) {
		return goodsMapper.addGoods(goods);
	}

	@Override
	public List<Goods> getAll() {
		return goodsMapper.getAllGoods();
	}
	
	@Override
	public int updateStock(Long id, int stock) {
		return goodsMapper.updateStock(id, stock);
	}

}
