package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserJpaRespository;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserNameEmailDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserJpaRespository userJpaRepsitory;
	
	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userJpaRepsitory.findAll();
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for(User user : users)
		{
			UserDto dto = new UserDto(user);
			userDtos.add(dto);
		}
		return userDtos;
	}

	@Override
	public void save(UserDto dto) {
		
		User user = dto.getEntity();
		this.userJpaRepsitory.save(user);
	}

	@Override
	public void deleteById(Long id) {
		this.userJpaRepsitory.deleteById(id);
		
	}


	@Override
	public List<UserDto> searchUserByName(String name) {
		List<User> users = this.userJpaRepsitory.findByNameLikeNative(name);
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for(User user : users)
		{
			System.out.println("Class "+user.getClass().getSuperclass().getName());
			UserDto dto = new UserDto(user);
			userDtos.add(dto);
		}
		List<UserNameEmailDto> dtos = this.userJpaRepsitory.findUserNameEmail();
		
		for(UserNameEmailDto dto : dtos)
		{
			System.out.println("Class "+dto.getClass());
			System.out.println("Name "+dto.getName() +" Email "+dto.getEmail());
		}
		return userDtos;
	}

}
