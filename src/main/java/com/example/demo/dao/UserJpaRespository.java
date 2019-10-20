package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserNameEmailDto;
import com.example.demo.entity.User;

@Repository
public interface UserJpaRespository extends JpaRepository<User, Long> {

	List<User> findByName(String name);
	
	@Query("FROM User WHERE name LIKE CONCAT('%',:name,'%') ")
	List<User> findByNameLike(@Param("name")String name);
	
	@Query(value="SELECT * FROM User WHERE name LIKE CONCAT('%',:name,'%') ",nativeQuery=true)
	List<User> findByNameLikeNative(@Param("name")String name);
	
	@Query(value="SELECT name,email FROM User ",nativeQuery=true)
	List<UserNameEmailDto> findUserNameEmail();
}
 