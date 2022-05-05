package com.kiruthiga.giftshopapp.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kiruthiga.giftshopapp.model.User;




@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmailAndPassword(String email, String password);
	
	@Transactional
	@Modifying
	@Query("update User u set u.name = :name where u.id=:id")
	void changeName(@Param("id") Integer id, @Param("name") String name);
	
}
