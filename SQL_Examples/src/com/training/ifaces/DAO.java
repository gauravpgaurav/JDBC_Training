package com.training.ifaces;

import java.util.List;

//Data Access Object
public interface DAO<T> {

	public int add(T t);
	public T find(int key);
	public List<T> findAll();
	public int update(int key);
	public int delete(int key);

}
