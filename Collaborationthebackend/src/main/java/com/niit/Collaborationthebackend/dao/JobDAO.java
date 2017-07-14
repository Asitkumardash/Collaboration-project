package com.niit.Collaborationthebackend.dao;

import java.util.List;

import com.niit.Collaborationthebackend.dto.Job;



public interface JobDAO {

	Job get(int id);
	List<Job> list();
	boolean add(Job job);
	boolean update(Job job);
	boolean delete(Job job);
	
	
	
}
