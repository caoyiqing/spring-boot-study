package com.cyq.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Goods {
	
	public interface Default{}
	
	public interface Update{}
	
	@NotNull(message = "货物ID不能为空" , groups = Update.class)
	private Long id;
	
	@NotNull(message = "货物名称不能为空" , groups = Default.class)
	private String goodsName;
	
	private String goodsDesc;
	
	@NotNull(message = "货物金额不能为空" , groups = Default.class)
	private Long money;
	
	@NotNull(message = "货物库存不能为空" , groups = Default.class)
	private int stock;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date updateTime;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") 
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
