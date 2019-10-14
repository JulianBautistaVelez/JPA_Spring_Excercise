package com.julian.bootmvchibernate.dao;

import java.util.List;

public interface  GeneralDAO<T> {
	public List<T> List();
	public T get(int id);
	public void update(T objeto);
	public void add(T objeto);
	public void delete(int id);
	

}
