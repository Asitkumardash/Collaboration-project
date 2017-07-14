package com.niit.Collaborationthebackend.dao;

import java.util.List;

import com.niit.Collaborationthebackend.dto.Eventpart;


public interface EventpartDAO {

	Eventpart get(int id);
	List<Eventpart> list();
	boolean add(Eventpart eventpart);
	boolean update(Eventpart eventpart);
	boolean delete(Eventpart eventpart);
	
	List<Eventpart> listByEpNumber(int evtid);
	List<Eventpart> participatedEvents(int userid);
}
