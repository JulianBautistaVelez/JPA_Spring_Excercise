package com.julian.bootmvchibernate.service;

import java.util.List;

public interface GeneralService<T> {

	public List<T> list();
	public T get(int id);
	public void update(T objeto);
	public void add(T user);
	public void delete(int id);
}
