package com.niit.Collaborationthebackend.dao;

import java.util.List;

import com.niit.Collaborationthebackend.dto.Jobapp;



public interface JobappDAO {

	Jobapp get(int id);
	List<Jobapp> list();
	boolean add(Jobapp jobapp);
	boolean update(Jobapp jobapp);
	boolean delete(Jobapp jobapp);
	
	List<Jobapp> listByJobid(int jobid);
	List<Jobapp> appliedJobs(int userid);
}
