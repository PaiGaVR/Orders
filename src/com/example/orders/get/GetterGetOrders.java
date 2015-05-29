package com.example.orders.get;

public class GetterGetOrders {
	private int icon_id;
	private String getterGetOrders_name;
	private String getterGetOrders_time;
	private String getterGetOrders_place;
	private String getterGetOrders_money;
	private String getterGetOrders_type;

	public GetterGetOrders() {

	}

	public GetterGetOrders(String getterGetOrders_name, String getterGetOrders_time, String getterGetOrders_place,
			String getterGetOrders_money, String getterGetOrders_type) {
		this.getterGetOrders_name = getterGetOrders_name;
		this.getterGetOrders_time = getterGetOrders_time;
		this.getterGetOrders_place = getterGetOrders_place;
		this.getterGetOrders_money = getterGetOrders_money;
		this.getterGetOrders_type = getterGetOrders_type;
	}

	public int getIcon_id() {
		return icon_id;
	}

	public void setIcon_id(int icon_id) {
		this.icon_id = icon_id;
	}

	public String getGetterGetOrders_name() {
		return getterGetOrders_name;
	}

	public void setGetterGetOrders_name(String getterGetOrders_name) {
		this.getterGetOrders_name = getterGetOrders_name;
	}

	public String getGetterGetOrders_time() {
		return getterGetOrders_time;
	}

	public void setGetterGetOrders_time(String getterGetOrders_time) {
		this.getterGetOrders_time = getterGetOrders_time;
	}

	public String getGetterGetOrders_place() {
		return getterGetOrders_place;
	}

	public void setGetterGetOrders_place(String getterGetOrders_place) {
		this.getterGetOrders_place = getterGetOrders_place;
	}

	public String getGetterGetOrders_money() {
		return getterGetOrders_money;
	}

	public void setGetterGetOrders_money(String getterGetOrders_money) {
		this.getterGetOrders_money = getterGetOrders_money;
	}

	public String getGetterGetOrders_type() {
		return getterGetOrders_type;
	}

	public void setGetterGetOrders_type(String getterGetOrders_type) {
		this.getterGetOrders_type = getterGetOrders_type;
	}

}
