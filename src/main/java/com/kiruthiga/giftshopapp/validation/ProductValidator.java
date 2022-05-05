package com.kiruthiga.giftshopapp.validation;

import org.springframework.stereotype.Component;

import com.kiruthiga.giftshopapp.model.Products;

@Component
public class ProductValidator{

	
		public void giftVaidation(Products product) throws Exception 
		{
			if(product.getGiftName()==null ||  (product.getGiftName()).trim()=="") 
			{
				
				throw new Exception("INVALID  Gift Name!!!");
			}
			
			if(product.getGiftPrice()==null || product.getGiftPrice()<=0)
			{
				throw new Exception("INVALID Gift Price!!");
				
			}
			 
	}

}
