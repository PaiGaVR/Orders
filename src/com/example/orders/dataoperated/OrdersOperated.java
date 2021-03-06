package com.example.orders.dataoperated;

import java.util.List;

import com.example.orders.avatar.AvatarMessage;
import com.example.orders.entity.Orders;
import com.example.orders.push.PusherGetGetter;

public class OrdersOperated {
	public static OrdersOperated ordersOperated = null;

	private List<Orders> pushOrdersList = null;
	private List<Orders> getOrdersList = null;
	private List<Orders> pushingOrdersList = null;
	private List<Orders> overOrdersList = null;
	private List<AvatarMessage> messageBoardList = null;
	private List<PusherGetGetter> getterList = null;

	private Data data;

	private OrdersOperated() {
		data = new Data();
	}

	public static OrdersOperated getInstance() {
		if (ordersOperated == null)
			ordersOperated = new OrdersOperated();

		return ordersOperated;
	}

	/**
	 * 写order
	 * 
	 * @param order
	 * @return PushOrders列表
	 */
	public List<Orders> writeOrder(Orders order) {
		if (pushOrdersList == null)
			pushOrdersList = data.getPushOrdersList();

		pushOrdersList.add(0, order);
		return pushOrdersList;
	}

	/**
	 * 读PushOrders列表
	 * 
	 * @return PushOrders列表
	 */
	public List<Orders> getPushOrdersList() {
		if (pushOrdersList == null)
			pushOrdersList = data.getPushOrdersList();

		return pushOrdersList;
	}

	/**
	 * 读GetOrders列表
	 * 
	 * @return GetOrders列表
	 */
	public List<Orders> getGetOrdersList() {
		if (getOrdersList == null)
			getOrdersList = data.getGetOrdersList();

		return getOrdersList;
	}

	/**
	 * 读PushingOrders列表
	 * 
	 * @return PushingOrders列表
	 */
	public List<Orders> getPushingOrders() {
		if (pushingOrdersList == null)
			pushingOrdersList = data.getPushingOrdersList();

		return pushingOrdersList;
	}

	/**
	 * 读OverOrders列表
	 * 
	 * @return OverOrders列表
	 */
	public List<Orders> getOverOrders() {
		if (overOrdersList == null)
			overOrdersList = data.getOverOrdersList();

		return overOrdersList;
	}

	/**
	 * 读MessageBoard列表
	 * 
	 * @return MessageBoard列表
	 */
	public List<AvatarMessage> getMessageBoardList() {
		if (messageBoardList == null)
			messageBoardList = data.getMessageBoardList();

		return messageBoardList;
	}
	
	/**
	 * 读getterList列表
	 * 
	 * @return getterList列表
	 */
	public List<PusherGetGetter> getGetterList() {
		if (getterList == null)
			getterList = data.getGetterList();

		return getterList;
	}
}
