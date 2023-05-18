package com.xhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BbSbootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BbSbootApplication.class, args);
	}
	
}
