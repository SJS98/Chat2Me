package com.chatwithme.service;

import java.util.List;

import com.chatwithme.entities.Massages;
import com.chatwithme.entities.User;

public interface UserService {

	public List<User> getAllUsers();
	public User isValidUser(String id, String pass);
	public boolean addNewUser(User user);
	User getUser(String id);
	public String sendMsg(String msgFrom, String msgTo, String msg);
	public void deleteAllUsers();
	public void deleteOfUser(String id);
	public List<Massages> getConversations(String sender, String receiver);

}
