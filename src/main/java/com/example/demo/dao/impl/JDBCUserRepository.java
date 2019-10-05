package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.User;

@Repository
public class JDBCUserRepository implements UserRepository{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<User> findAll() {
		return jdbc.query("select id, name, email from User",
			      this::mapRowToUser);
	}

	@Override
	public User findOne(Long id) {
		return jdbc.queryForObject(
			      "select id, name, email from User where id=?",
			      this::mapRowToUser, id);
	}

	@Override
	public User save(User user) {
		jdbc.update(
			      "insert into User ( name, email) values (?, ?)",
			      user.getName(),
			      user.getEmail());
		return user;
	}
	private User mapRowToUser(ResultSet rs, int rowNum)
		    throws SQLException {
		  return new User(
		      rs.getLong("id"),
		      rs.getString("name"),
		      rs.getString("email"));
		}


}
