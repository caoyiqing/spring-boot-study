package com.cyq;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.cyq.entity.Goods;
import com.cyq.service.GoodsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private GoodsService goodsService;
	
	@Test
	public void getAll() {
		List<Goods> goods = goodsService.getAll();
		System.out.println(JSON.toJSONString(goods));
	}

}
