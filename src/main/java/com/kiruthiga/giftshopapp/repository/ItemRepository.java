package com.kiruthiga.giftshopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiruthiga.giftshopapp.model.Items;


@Repository
public interface ItemRepository  extends JpaRepository<Items,Integer>{

}
