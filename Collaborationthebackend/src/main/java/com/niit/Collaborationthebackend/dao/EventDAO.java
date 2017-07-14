package com.niit.Collaborationthebackend.dao;

import java.util.List;

import com.niit.Collaborationthebackend.dto.Adminevent;


public interface EventDAO {

	Adminevent get(int id);
	List<Adminevent> list();
	boolean add(Adminevent evt);
	boolean update(Adminevent evt);
	boolean delete(Adminevent evt);
	
}
