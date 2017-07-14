package com.niit.Collaborationthebackend.dao;

import java.util.List;

import com.niit.Collaborationthebackend.dto.Friend;
import com.niit.Collaborationthebackend.dto.Usertable;



public interface FriendDAO {

	Friend get(int id);
	List<Friend> list();
	boolean add(Friend friend);
	boolean update(Friend friend);
	boolean delete(Friend friend);
	Friend getByUsers(int userid1, int userid2);
	
	// fr request sent
	List<Usertable> frlist(int userid);
	
	// fr req received
	List<Usertable> frReqrcvlist(int userid);
	
	// other people
	List<Usertable> notfrlist(int userid);
	
	// my friends req accepted
	List<Usertable> myfrlist(int userid);
	
	
}
