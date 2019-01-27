package com.cyq.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {
	
	private Long id;
	
	private String orderNum;
	
	private Long goodsId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
