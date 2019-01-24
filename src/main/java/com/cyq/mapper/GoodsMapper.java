package com.cyq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cyq.entity.Goods;

@Mapper
public interface GoodsMapper {
	
	List<Goods> getAllGoods();

	int updateStock(@Param("id") Long id, @Param("stock") int stock);

}
