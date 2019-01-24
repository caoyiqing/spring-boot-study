package com.cyq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.cyq.bean.MyBean;

@SpringBootApplication
public class SpringBootStudyApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyApplication.class, args);

		// SpringApplication sa = new
		// SpringApplication(SpringBootStudyConfigApplication.class);
		// sa.setAdditionalProfiles("dev", "devdb");
		// sa.run(args);
	}

	@Autowired
	MyBean mybean;

	@Autowired
	Environment environment;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 配置文件的读取，默认先从resources/config/下的application.properties  application.yml
		// 再resources/下的application.properties  application.yml
		System.out.println("***************** " + mybean);
		// System.out.println("*****************" +
		// environment.getProperty("my.text"));
	}
}
