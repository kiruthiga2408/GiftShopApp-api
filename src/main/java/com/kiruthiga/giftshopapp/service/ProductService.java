package com.kiruthiga.giftshopapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kiruthiga.giftshopapp.model.Products;
import com.kiruthiga.giftshopapp.repository.ProductRepository;
import com.kiruthiga.giftshopapp.validation.ProductValidator;
	@Component
    public class ProductService {
	@Autowired
	ProductRepository  productRepository;
	@Autowired
	ProductValidator productValidator;
	
	
	/*public List<Products> displayGifts(Products product){
		List<Products> listall=productRepository.findAll();
		 return listall;

	}
	*/
  
	public void save(Products product) throws Exception
	{
		try {
			productValidator.giftVaidation(product);
			productRepository.save(product);
		}
		catch(Exception e)
		{
		  throw new Exception(e.getMessage());
		}
		
	}
    
}