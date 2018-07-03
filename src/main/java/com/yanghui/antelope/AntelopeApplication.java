package com.yanghui.antelope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AntelopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntelopeApplication.class,args);
	}
}
