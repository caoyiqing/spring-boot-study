package com.cyq.response;

import java.util.List;

public class PageData<T> {
	
	private List<T> data;
	
	private long count;
	
	public PageData(List<T> data, long count) {
		this.data = data;
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public long getCount() {
		return count;
	}

}
