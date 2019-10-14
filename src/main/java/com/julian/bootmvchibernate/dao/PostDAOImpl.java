package com.julian.bootmvchibernate.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.julian.bootmvchibernate.model.Post;
import com.julian.bootmvchibernate.model.User;

@Repository
@Component("postDAO")
public class PostDAOImpl implements GeneralDAO<Post>{

	@PersistenceContext
	private EntityManager entityManager;
	
	public Post getPostById(int id) {
		return entityManager.find(Post.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Post> List() {
		String hql = "FROM Post ORDER BY POST_ID";
		return (List<Post>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Post get(int id) {
		return entityManager.find(Post.class, id);
	}

	@Override
	public void update(Post post) {
		Post postMod = getPostById(post.getId());
		postMod.setTittle(post.getTittle());
		//postMod.setUserId(post.getUserId());
		
		entityManager.flush();
	}

	@Override
	public void add(Post post) {
		System.out.println("--------------------------------------INSERTANDO EN BD-----------------------------------");
		System.out.println("--------------------------------------INSERTANDO EN BD-----------------------------------");
		System.out.println("--------------------------------------INSERTANDO EN BD-----------------------------------");
		System.out.println("--------------------------------------INSERTANDO EN BD-----------------------------------");
		System.out.println(post);
		entityManager.merge(post);
	}

	@Override
	public void delete(int id) {
		entityManager.remove(getPostById(id));
		
	}

}
