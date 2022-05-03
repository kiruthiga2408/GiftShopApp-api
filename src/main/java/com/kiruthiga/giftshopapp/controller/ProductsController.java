package com.kiruthiga.giftshopapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.kiruthiga.giftshopapp.model.Products;
import com.kiruthiga.giftshopapp.repository.ProductRepository;



 
@RestController
public class ProductsController {
	
	
	@Autowired
	ProductRepository productRepository;
	
	
	
     @PostMapping("Items/save") 
     public String save(@RequestBody  Products product) {
    	 productRepository.save(product);
    	return "Success"; 
     }
     
     
    
     @GetMapping("Items/listall") 
     public  List<Products>  findAll(){
		 List<Products> listall=productRepository.findAll();
		 return listall;
		 
		 
	 }
     @DeleteMapping("Items/{id}")
	 public  void delete(@PathVariable("id")  Integer id) {
		 productRepository.deleteById(id);
	 }
     
     @PutMapping("Item/{id}")
	 public void update(@PathVariable("id") Integer id,@RequestBody Products product) {
		 product.setGiftItemId(id);
		 productRepository.save(product);
	 }
	 
     @GetMapping("item/search")
 	public List<Products> findByName(@RequestParam("name") String giftName) {
 		System.out.println(giftName);
 		List<Products> product = productRepository.findAll();
 		List<Products> obtainedProducts = product.stream().filter(m-> m.getGiftName().toLowerCase().contains(giftName.toLowerCase())).collect(Collectors.toList());
 		return obtainedProducts;
 	}
      
     
}
