package com.chatwithme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatwithme.entities.Massages;
import com.chatwithme.entities.User;
import com.chatwithme.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home(){
		return "Welcome to ChatWithMe App";
	}

	@GetMapping("/allusers")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/userlogin")
	public User userLogIn(@RequestParam String id, @RequestParam String pass) {
		return userService.isValidUser(id,pass);
	}

	@PostMapping("/usersignup")
	public boolean userSignUp(@RequestBody User user) {
		return userService.addNewUser(user);
	}

	@DeleteMapping("/deleteall")
	public boolean deleteAll() {
		userService.deleteAllUsers();
		return false;
	}

	@DeleteMapping("/deleteallofuser")
	public boolean deleteAllOfUser(@RequestParam String id) {
		userService.deleteOfUser(id);
		return false;
	}

	//	sendmassage?msgFrom=sabir98@&msgTo=Ali98@&msg=Hi Ali

	/**
	 * Assumption:
	 * This method {@sendMassage()} can be get called only when both users are present in database. 
	 * 
	 * @param msgFrom - Id of sender
	 * @param msgTo - Id of receiver
	 * @param msg - Massage to be send
	 * @return true if massage get send successfully, else false
	 */

	@PostMapping("/sendmassage")
	public String sendMassage(@RequestParam String msgFrom, @RequestParam String msgTo, @RequestParam String msg) {
		return userService.sendMsg(msgFrom, msgTo, msg);
	}

	@GetMapping("/getmassages")
	public List<Massages> getAllMsg(@RequestParam String sender, @RequestParam String receiver) {
		return userService.getConversations(sender,receiver);
	}
	
}