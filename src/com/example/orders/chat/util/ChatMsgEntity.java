package com.example.orders.chat.util;

public class ChatMsgEntity {

	private String name;

	private String date;

	private String text;

	private boolean isComMeg = true;

	private boolean isImport = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getMsgType() {
		return isComMeg;
	}

	public void setMsgType(boolean isComMsg) {
		isComMeg = isComMsg;
	}

	public boolean getMsgTypeImport() {
		return isImport;
	}

	public void setMsgTypeImport(boolean isImport) {
		this.isImport = isImport;
	}

	public ChatMsgEntity() {
	}

	public ChatMsgEntity(String name, String date, String text,
			boolean isComMsg, boolean isImport) {
		this.name = name;
		this.date = date;
		this.text = text;
		this.isComMeg = isComMsg;
		this.isImport = isImport;
	}
}
