package com.kiruthiga.giftshopapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.kiruthiga.giftshopapp.service.ProductService;



 
@RestController
public class ProductsController {
	
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	
     @PostMapping("product/save") 
     public ResponseEntity<String> addProducts(@RequestBody  Products product) {
    	 try {
    		 productService.save(product);
    		 return new ResponseEntity<String>("Success",HttpStatus.OK);
    	 }
    	 catch(Exception e) {
    		 return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
     }
    	 
    // public String save(@RequestBody  Products product) {
    	// productRepository.save(product);
    	//return "Success"; 
     }
     
     
    
     @GetMapping("product/listall") 
     public  List<Products>  findAll(){
		 List<Products> listall=productRepository.findAll();
		 return listall;
		 
		 
	 }
     @DeleteMapping("products/{id}")
	 public  void delete(@PathVariable("id")  Integer id) {
		 productRepository.deleteById(id);
	 }
     
     @PutMapping("product/{id}")
	 public void update(@PathVariable("id") Integer id,@RequestBody Products product) {
		 product.setGiftItemId(id);
		 productRepository.save(product);
	 }
	 
     @GetMapping("products/search")
 	public List<Products> findByName(@RequestParam("name") String giftName) {
 		System.out.println(giftName);
 		List<Products> product = productRepository.findAll();
 		List<Products> filteredProducts = product.stream().filter(m-> m.getGiftName().toLowerCase().contains(giftName.toLowerCase())).collect(Collectors.toList());
 		return filteredProducts;
 	}
      
     
}
