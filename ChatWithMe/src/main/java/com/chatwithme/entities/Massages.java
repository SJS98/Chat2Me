package com.chatwithme.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Massages {

	@Id
	private String id;
	
	private String msg;
	
	private String msgFrom;
	private String msgTo;
	
//	@ManyToOne
//	private Conversations conversations;
	
	public Massages(String msgFrom, String msgTo, String msg) {
		this.id = new Date().toString();
		this.msg = msg;
		this.msgFrom = msgFrom;
		this.msgTo = msgTo;
	}
	
	public Massages() {}
	
	public String getId() {
		return id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsgFrom() {
		return msgFrom;
	}
	public void setMsgFrom(String msgFrom) {
		this.msgFrom = msgFrom;
	}
	public String getMsgTo() {
		return msgTo;
	}
	public void setMsgTo(String msgTo) {
		this.msgTo = msgTo;
	}

	@Override
	public String toString() {
		return String.format("Massages [id=%s, msg=%s]", id, msg);
	}
	
	
}
