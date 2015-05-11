package com.example.orders.entity;

public class Orders {
	/**
	 * 下单人ID
	 */
	private String pId;
	
	/**
	 * 下单人姓名
	 */
	private String pName;
	
	/**
	 * 单子状态
	 */
	private OrdersState state;
	
	/**
	 * 订单ID
	 */
	private String oId;
	
	/**
	 * 回单人ID
	 */
	private String rId;
	
	/**
	 * 回单人姓名
	 */
	private String name;
	
	/**
	 * 下单时间
	 */
	private String time;
	
	/**
	 * 单子主题
	 */
	private String theme;
	/**
	 * 单子内容
	 */
	private String content;
	
	/**
	 * 下单金额
	 */
	private String pushMoney;
	
	/**
	 * 回单金额
	 */
	private String receiptMoney;
	
	/**
	 * 单子目标地点
	 */
	private String aimArea;
	
	/**
	 * 单子目标时间
	 */
	private String aimTime;

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

	public OrdersState getState() {
		return state;
	}

	public void setState(OrdersState state) {
		this.state = state;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPushMoney() {
		return pushMoney;
	}

	public void setPushMoney(String pushMoney) {
		this.pushMoney = pushMoney;
	}

	public String getReceiptMoney() {
		return receiptMoney;
	}

	public void setReceiptMoney(String receiptMoney) {
		this.receiptMoney = receiptMoney;
	}

	public String getAimArea() {
		return aimArea;
	}

	public void setAimArea(String aimArea) {
		this.aimArea = aimArea;
	}

	public String getAimTime() {
		return aimTime;
	}

	public void setAimTime(String aimTime) {
		this.aimTime = aimTime;
	}
	
}
