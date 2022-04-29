package com.kiruthiga.giftshopapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiruthiga.giftshopapp.model.Items;
import com.kiruthiga.giftshopapp.repository.ItemRepository;



 
@RestController
public class ItemsController {
	
	
	@Autowired
	ItemRepository itemRepository;
	
	
	
     @PostMapping("Items/save") 
     public String save(@RequestBody  Items item) {
    	 itemRepository.save(item);
    	return "Success"; 
     }
     
     
    
     @GetMapping("Items/listall") 
     public  List<Items>  findAll(){
		 List<Items> listall=itemRepository.findAll();
		 return listall;
		 
		 
	 }
     @DeleteMapping("Items/{id}")
	 public  void delete(@PathVariable("id")  Integer id) {
		 itemRepository.deleteById(id);
	 }
     
     @PutMapping("Item/{id}")
	 public void update(@PathVariable("id") Integer id,@RequestBody Items item) {
		 item.setId(id);
		 itemRepository.save(item);
	 }
	 
      
     
}
