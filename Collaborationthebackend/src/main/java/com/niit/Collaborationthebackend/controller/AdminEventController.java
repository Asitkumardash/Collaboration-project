package com.niit.Collaborationthebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Collaborationthebackend.dao.EventDAO;
import com.niit.Collaborationthebackend.dto.Adminevent;



@RestController
public class AdminEventController {
/*
	@Autowired
	HttpSession session;
*/
	@Autowired
	EventDAO eventDAO;
	
	@Autowired
	Adminevent evt;
	
	@RequestMapping(value="/adminevent/new",method = RequestMethod.POST)
	public ResponseEntity<Adminevent> addNewAdminEvent(@RequestBody Adminevent evt) {
		System.out.println("Adding new event");
			
			boolean b =eventDAO.add(evt);
			if(b) System.out.println("Event added Successfully");
			else System.out.println("Event NOT added");
			
		return new ResponseEntity<Adminevent>(evt, HttpStatus.OK);
	}
	
		// edit event
		@RequestMapping(value="/edit/event",method = RequestMethod.POST)
		public ResponseEntity<Adminevent> editAdminEvt(@RequestBody Adminevent evt) {
			System.out.println("edit event");
				// getting old data
			Adminevent evt1 = eventDAO.get(evt.getEvtid());
				// added new data to old event
				evt1 = evt;
				
				boolean b =eventDAO.update(evt1);
				if(b) System.out.println("Event updated Successfully");
				else System.out.println("Event not updated");
				
			return new ResponseEntity<Adminevent>(evt1, HttpStatus.OK);
		}
	
	 // to retrieve list of events
	 @RequestMapping(value = {"/adminevent/list"}, method = RequestMethod.GET)
		public ResponseEntity<List<Adminevent>> fetchAdminEvents() {
			System.out.println("fetching list of Adminevent");
			List<Adminevent> evt = eventDAO.list();
			return new ResponseEntity<List<Adminevent>>(evt, HttpStatus.OK);
		}
	 
	 // to get single event 
	 @RequestMapping(value = {"/adminevent/{id}"}, method = RequestMethod.GET)
		public ResponseEntity<Adminevent> viewSingleEvent(@PathVariable("id") int id) {
			System.out.println("Calling single event method");
			Adminevent evt = null;
			evt = eventDAO.get(id);
			
			
			/*blogDAO.updateBlog(blog);*/
			if(evt == null) {
				evt = new Adminevent();
				evt.setErrCode("404");
				evt.setErrMessage("event not found!");
			}
			else {
				evt.setErrCode("200");
				evt.setErrMessage("event found!");
			}
			System.out.println("End of single evt method");
			return new ResponseEntity<Adminevent>(evt, HttpStatus.OK);
			
		}
	 
	 // delete an event
	 @RequestMapping(value="/adminevent/delete/{eventid}",method = RequestMethod.POST)
		public ResponseEntity<Adminevent> deleteAnEvent(@PathVariable("eventid") int eventid) {
			System.out.println("Deleting an event");
				
				Adminevent evt = eventDAO.get(eventid);
			
				boolean b =eventDAO.delete(evt);
				if(b) System.out.println("Event deleted Successfully");
				else System.out.println("Event NOT deleted");
				
			return new ResponseEntity<Adminevent>(evt, HttpStatus.OK);
		}
	 
	 
	 
	 /********************************/
}
