package com.example.orders.entity;

import java.util.List;

public class Persion {
	/**
	 * 人物ID
	 */
	private String id;

	/**
	 * 头像
	 */
	private String headImg;

	/**
	 * 账号名
	 */
	private String name;

	/**
	 * 手机/登陆账号
	 */
	private String phone;

	/**
	 * 密码
	 */
	private String passwd;

	/**
	 * 身份证号
	 */
	private String pId;

	/**
	 * 姓名
	 */
	private String pName;

	/**
	 * 下单数
	 */
	private int pushNum;

	/**
	 * 接单数
	 */
	private int getNum;

	/**
	 * 荣誉值
	 */
	private long honourNum;

	/**
	 * 留言列表
	 */
	private List<String> leavedMessage;

	public List<String> getLeavedMessage() {
		return leavedMessage;
	}

	public void setLeavedMessage(List<String> leavedMessage) {
		this.leavedMessage = leavedMessage;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPushNum() {
		return pushNum;
	}

	public void setPushNum(int pushNum) {
		this.pushNum = pushNum;
	}

	public int getGetNum() {
		return getNum;
	}

	public void setGetNum(int getNum) {
		this.getNum = getNum;
	}

	public long getHonourNum() {
		return honourNum;
	}

	public void setHonourNum(long honourNum) {
		this.honourNum = honourNum;
	}

}
