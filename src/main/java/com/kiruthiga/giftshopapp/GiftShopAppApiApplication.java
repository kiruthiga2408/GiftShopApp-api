package com.kiruthiga.giftshopapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GiftShopAppApiApplication {
	 private static Logger log=LoggerFactory.getLogger(GiftShopAppApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GiftShopAppApiApplication.class, args);
		log.info("Welcome!!!");
		
	}

}
