package com.example.orders.entity;

public enum OrdersState {
	PUSHING("等待接单", 1), GETING("进行中", 2), OVER("完成", 3);

	private int index;
	private String name;

	private OrdersState(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public static String getName(int index) {
		for (OrdersState o : OrdersState.values()) {
			if (o.getIndex() == index)
				return o.getName();
		}
		return null;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
