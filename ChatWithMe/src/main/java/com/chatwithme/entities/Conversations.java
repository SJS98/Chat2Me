package com.chatwithme.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Conversations {

	/**
	 * id - This id is made by assebmling two user ids - for example. { User1 Id =
	 * xyz@123, User2 Id = abc@789 } then id of thier conversations will be {id =
	 * xyz@123abc@789}.Based on this id we can identify conversation between two
	 * users.
	 */

	@Id
	private String id;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Massages> allMsgs;

	public Conversations() {
		allMsgs = new ArrayList<Massages>();
	}

	public Conversations(String id, ArrayList<Massages> allmsgs) {
		super();
		this.id = id;
		this.allMsgs = allmsgs;
	}

	public Conversations(String id) {
		this.id = id;
		allMsgs = new ArrayList<Massages>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Massages> getAllMsgs() {
		return allMsgs;
	}

	public void newMsgs(Massages newMsg) {
		this.allMsgs.add(newMsg);
	}

	public void clearConversations() {
		allMsgs.clear();
	}

	@Override
	public String toString() {
		return this.id + " : " + allMsgs;
	}

}
