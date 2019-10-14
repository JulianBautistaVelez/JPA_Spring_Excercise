package com.julian.bootmvchibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.julian.bootmvchibernate.dao.GeneralDAO;
import com.julian.bootmvchibernate.dao.UserDAO;
import com.julian.bootmvchibernate.model.User;



@Service
@Transactional
@Component("userService")
public class UserServiceImpl implements GeneralService<User> {

	@Autowired
	@Qualifier("userDAO")
	private GeneralDAO<User> userDAO;

	
	/*public UserServiceImpl(UserDAO userDAO) {
		this.userDAO =userDAO;
	}*/

	@Override
	public List<User> list() {
		return userDAO.List();
	}

	@Override
	public User get(int id) {
		System.out.println("--------------------------------------------");
		System.out.println("-------------LLAMANDO USER GET--------------");
		return userDAO.get(id);
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public void add(User user) {
		userDAO.add(user);
	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
	}

}
