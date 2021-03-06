package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;

@Repository
public class JDBCUserRepository implements UserRepository{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<UserDto> findAll() {
		return jdbc.query("select id, name, email from User",
			      this::mapRowToUser);
	}

	@Override
	public UserDto findOne(Long id) {
		return jdbc.queryForObject(
			      "select id, name, email from User where id=?",
			      this::mapRowToUser, id);
	}

	@Override
	public UserDto save(UserDto user) {
		jdbc.update(
			      "insert into User ( name, email) values (?, ?)",
			      user.getName(),
			      user.getEmail());
		return user;
	}
	private UserDto mapRowToUser(ResultSet rs, int rowNum)
		    throws SQLException {
		  return new UserDto(
		      rs.getLong("id"),
		      rs.getString("name"),
		      rs.getString("email"));
		}

	@Override
	public UserDto update(UserDto user) {
		jdbc.update(
			      "Update User set  name=?, email=? WHERE id=?",
			      user.getName(),
			      user.getEmail(),
			      user.getId());
		return user;
	}

	@Override
	public void delete(Long id) {
		jdbc.update(
			      "DELETE FROM User WHERE id=?",
			      id);
	}


}
