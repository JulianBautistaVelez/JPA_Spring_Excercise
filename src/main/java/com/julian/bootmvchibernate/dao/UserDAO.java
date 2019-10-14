package com.julian.bootmvchibernate.dao;

import java.util.List;

import com.julian.bootmvchibernate.model.User;

public interface UserDAO {
	public List<User> List();
	
	public User get(int id);
	public void update(User user);
	public void add(User User);
	public void delete(int id);
	
}
