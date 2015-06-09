package com.example.orders.dataoperated;

import java.util.ArrayList;
import java.util.List;

import com.example.orders.avatar.AvatarMessage;
import com.example.orders.entity.Orders;
import com.example.orders.push.PusherGetGetter;

public class Data {
	private List<Orders> pushOrdersList = null;
	private List<Orders> getOrdersList = null;
	private List<Orders> pushingOrdersList = null;
	private List<Orders> overOrdersList = null;
	private List<AvatarMessage> messageBoardList = null;
	private List<PusherGetGetter> getterList = null;

	public Data() {
		initPushOrdersList();
		initGetOrdersList();
		initPushingOrdersList();
		initOverOrdersList();
		initMessageBoardList();
		initGetterList();
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

	private void initMessageBoardList() {
		messageBoardList = new ArrayList<AvatarMessage>();
	}

	private void initGetterList() {
		getterList = new ArrayList<PusherGetGetter>();
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

	public List<AvatarMessage> getMessageBoardList() {
		return messageBoardList;
	}

	public List<PusherGetGetter> getGetterList() {
		return getterList;
	}
}
