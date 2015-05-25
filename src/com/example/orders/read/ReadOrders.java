package com.example.orders.read;

public class ReadOrders {
	private int icon_id;
	private String orderTheme;
	private String getterName;
	private String getMoney;
	private String getTime;

	public ReadOrders() {

	}

	public ReadOrders(String orderTheme, String getterName,
			String getMoney, String getTime) {
		this.orderTheme = orderTheme;
		this.getterName = getterName;
		this.getMoney = getMoney;
		this.getTime = getTime;
	}

	public int getIcon_id() {
		return icon_id;
	}

	public void setIcon_id(int icon_id) {
		this.icon_id = icon_id;
	}

	public String getOrderTheme() {
		return orderTheme;
	}

	public void setOrderTheme(String orderTheme) {
		this.orderTheme = orderTheme;
	}

	public String getGetterName() {
		return getterName;
	}

	public void setGetterName(String getterName) {
		this.getterName = getterName;
	}

	public String getGetMoney() {
		return getMoney;
	}

	public void setGetMoney(String getMoney) {
		this.getMoney = getMoney;
	}

	public String getGetTime() {
		return getTime;
	}

	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}


}
