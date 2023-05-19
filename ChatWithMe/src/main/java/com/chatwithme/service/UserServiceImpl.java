package com.chatwithme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.chatwithme.dao.ConversationDao;
import com.chatwithme.dao.UserDao;
import com.chatwithme.entities.Conversations;
import com.chatwithme.entities.Massages;
import com.chatwithme.entities.User;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ConversationDao conDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUser(String id) {
		if (userDao.existsById(id))
			return (User) userDao.findById(id).get();
		return null;
	}

	@Override
	public User isValidUser(String id, String pass) {
		User userFound = null;
		boolean correct = false;
		if (userDao.existsById(id)) {
			userFound = (User) userDao.findById(id).get();
			correct = userFound != null ? userFound.getPass().equals(pass) : false;
		}
		return correct ? userFound : null;
	}

	@Override
	public boolean addNewUser(User user) {
		if (!userDao.existsById(user.getId())) {
			return userDao.save(user) != null;
		}
		return false;
	}

	@Override
	public void deleteAllUsers() {
		userDao.deleteAll();
	}

	@Override
	public void deleteOfUser(String id) {
		User user = userDao.findById(id).get();
		user.deleteAllConversation(null);
	}

	@Override
	public String sendMsg(String msgFrom, String msgTo, String msg) {
		Optional<Conversations> con = conDao.findById(msgFrom.concat(msgTo));
		Conversations conversation = null;

		
		// If two users chating first time
		if (con.isEmpty()) 
			conversation = new Conversations(msgFrom.concat(msgTo));

		// If two users already has chats
		else 
			conversation = con.get();

		conversation.newMsgs(new Massages(msgFrom, msgTo, msg));
		System.out.println(conversation.getAllMsgs());
		conDao.save(conversation);

		return "Massage sent";
	}
	
	@Override
	public List<Massages> getConversations(String sender, String receiver) {
		Optional<Conversations> con = conDao.findById(sender.concat(receiver));
		if(con.isEmpty())
			return null;
		return con.get().getAllMsgs();
		
	}
}