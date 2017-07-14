package com.niit.Collaborationthebackend.dao;

import java.util.List;

import com.niit.Collaborationthebackend.dto.Blog;



public interface BlogDAO {

	Blog get(int id);
	List<Blog> list();
	boolean add(Blog blog);
	boolean update(Blog blog);
	boolean delete(Blog blog);

	public List<Blog> nabloglist();
	public List<Blog> userbloglist(int userid);
}
