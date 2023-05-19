package com.chatwithme.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	private String id;

	private String pass;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Conversations> allConversations;

	public User() {
	}

	public User(String id, String pass, String name) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.allConversations = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNewConversatoin(Conversations conversations) {
		allConversations.add(conversations);
	}

	/**
	 * This method {getAllConversations()} will return all conversations of all
	 * users with this {@user}.
	 * 
	 * @return
	 */
	public List<Conversations> getAllConversations() {
		return this.allConversations;
	}

	public void deleteAllConversation(Conversations object) {
		allConversations.clear();
	}

	@Override
	public String toString() {
		return this.id + ":" + this.pass;
	}

	@Override
	public boolean equals(Object nextUser) {
		return this.id.equals(((User) nextUser).getId());
	}
}