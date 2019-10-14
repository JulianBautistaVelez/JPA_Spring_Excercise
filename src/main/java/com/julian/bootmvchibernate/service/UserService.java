package com.julian.bootmvchibernate.service;

import java.util.List;

import com.julian.bootmvchibernate.model.User;

public interface UserService {
	public List<User> list();
	
	public User get(int id);
	public void update(User user);
	public void add(User user);
	public void delete(int id);

}
