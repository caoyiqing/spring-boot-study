package com.cyq.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@Value("${my.name}")
	private String name;

	@Value("${my.age}")
	private int age;

	@Value("${my.cup}")
	private String cup;

	@Override
	public String toString() {
		return "MyBean [name=" + name + ", age=" + age + ", cup=" + cup + "]";
	}

}
