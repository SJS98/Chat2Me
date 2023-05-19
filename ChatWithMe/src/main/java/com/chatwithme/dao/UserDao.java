package com.chatwithme.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatwithme.entities.User;

public interface UserDao extends JpaRepository< User, String >{
	
}