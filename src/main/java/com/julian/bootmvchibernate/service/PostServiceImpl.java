package com.julian.bootmvchibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.julian.bootmvchibernate.dao.GeneralDAO;
import com.julian.bootmvchibernate.model.Post;

@Service
@Transactional
@Component("postService")
public class PostServiceImpl implements GeneralService<Post>{
	
	@Autowired
	@Qualifier("postDAO")
	private GeneralDAO<Post> postDao;

	@Override
	public List<Post> list() {
		System.out.println("-- Listando en PostService");
		return postDao.List();
	}

	@Override
	public Post get(int id) {
		return postDao.get(id);
	}

	@Override
	public void update(Post post) {
		postDao.update(post);
	}

	@Override
	public void add(Post post) {
		postDao.add(post);
		
	}

	@Override
	public void delete(int id) {
		postDao.delete(id);
	}

}
