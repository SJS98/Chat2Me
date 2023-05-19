package com.chatwithme.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatwithme.entities.Conversations;

public interface ConversationDao extends JpaRepository< Conversations, String >{
	
}