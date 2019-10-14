package com.julian.bootmvchibernate.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.julian.bootmvchibernate.model.User;

@Repository
@Component("userDAO")
public class UserDAOImpl implements GeneralDAO<User> {

	@PersistenceContext	
	private EntityManager entityManager;
	
	public UserDAOImpl() {}
	
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<User> List() {
		String hql = "FROM User ORDER BY USER_ID";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public User get(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void update(User user) {
		User usuario = getUserById(user.getId());
		usuario.setUsername(user.getUsername());
		usuario.setEmail(user.getEmail());
		usuario.setPassword(user.getPassword());
		
		entityManager.flush();
		
	}

	@Override
	public void add(User user) {
		entityManager.merge(user);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		entityManager.remove(getUserById(id));
		
	}
	
}
