package com.niit.CollaborationthebackendTestCase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Collaborationthebackend.config.RootConfig;
import com.niit.Collaborationthebackend.dao.FriendDAO;
import com.niit.Collaborationthebackend.dto.Friend;



public class FriendTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static FriendDAO friendDAO;
	
	private Friend friend;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext(RootConfig.class);

		
		friendDAO = (FriendDAO) context.getBean("friendDAO");
		
	}
	
	@Test
	public void testCRUDFriend() {
		//add operation
		friend =new Friend();
		
		friend.setUserid1(12);
		friend.setUserid2(13);
		
		assertEquals("Successfully added a friend in the table",true,friendDAO.add(friend));
		
		friend =new Friend();
		
		friend.setUserid1(23);
		friend.setUserid2(24);
		
		assertEquals("Successfully added a friend in the table",true,friendDAO.add(friend));
		
		
		//fetchaing and updating
		friend = friendDAO.get(2);
		
		friend.setUserid2(25);
	
		assertEquals("Successfully updated a friend in the table",true,friendDAO.update(friend));
		
		//deleting
		friend = friendDAO.get(2);
		assertEquals("Successfully deleted a friend in the table",true,friendDAO.delete(friend));
		
		//fetching the list
		assertEquals("Successfully fetched the list of friends from the table",1,friendDAO.list().size());
		
	}
}