package com.example.orders.dataoperated;

import java.util.ArrayList;
import java.util.List;

import com.example.orders.entity.Orders;

public class Data {
	private List<Orders> pushOrdersList = null;
	private List<Orders> getOrdersList = null;
	private List<Orders> pushingOrdersList = null;
	private List<Orders> overOrdersList = null;

	public Data() {
		initPushOrdersList();
		initGetOrdersList();
		initPushingOrdersList();
		initOverOrdersList();
	}

	/**
	 * 下单界面数据初始化
	 */
	private void initPushOrdersList() {
		pushOrdersList = new ArrayList<Orders>();
	}

	private void initGetOrdersList() {
		getOrdersList = new ArrayList<Orders>();
	}

	private void initPushingOrdersList() {
		pushingOrdersList = new ArrayList<Orders>();
	}

	private void initOverOrdersList() {
		overOrdersList = new ArrayList<Orders>();
	}

	public List<Orders> getPushOrdersList() {
		return pushOrdersList;
	}

	public List<Orders> getGetOrdersList() {
		return getOrdersList;
	}

	public List<Orders> getPushingOrdersList() {
		return pushingOrdersList;
	}

	public List<Orders> getOverOrdersList() {
		return overOrdersList;
	}
}
