package com.kiruthiga.giftshopapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.kiruthiga.giftshopapp.model.Products;


@Repository
public interface ProductRepository  extends JpaRepository<Products,Integer>{


}
