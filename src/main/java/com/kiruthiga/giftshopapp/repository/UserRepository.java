package com.kiruthiga.giftshopapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiruthiga.giftshopapp.model.Items;
import com.kiruthiga.giftshopapp.model.User;




@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


	   

}
