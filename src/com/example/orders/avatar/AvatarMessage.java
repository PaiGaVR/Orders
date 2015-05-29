package com.example.orders.avatar;

public class AvatarMessage {
	private int icon_id;
	private String name;
	private String msg;

	public AvatarMessage() {

	}

	public AvatarMessage(String name, String msg) {
		this.name = name;
		this.msg = msg;
	}

	public int getIcon_id() {
		return icon_id;
	}

	public void setIcon_id(int icon_id) {
		this.icon_id = icon_id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
