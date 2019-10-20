package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.*;

public interface UserService {

	List<UserDto> getAllUser();
	
	void save(UserDto dto);
	void deleteById(Long id);
	List<UserDto> searchUserByName(String name);
}
