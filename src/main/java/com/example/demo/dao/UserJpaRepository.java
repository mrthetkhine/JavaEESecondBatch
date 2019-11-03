package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserNameEmailDto;
import com.example.demo.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User> {

	List<User> findByName(String name);
	
	@Query("FROM User WHERE name LIKE CONCAT('%',:name,'%') ")
	List<User> findByNameLike(@Param("name")String name);
	
	@Query(value="SELECT * FROM User WHERE name LIKE CONCAT('%',:name,'%') ",nativeQuery=true)
	List<User> findByNameLikeNative(@Param("name")String name);
	
	@Query(value="SELECT name,email FROM User ",nativeQuery=true)
	List<UserNameEmailDto> findUserNameEmail();
	
	@Transactional
	@Modifying
	@Query("update User u set u.name = ?1 where u.id = ?2")
	int updateUserName(String name, Long id);
}
 