package com.example.orders.dataoperated;

import com.example.orders.entity.Persion;

public class PermissionOperated {
	private static PermissionOperated permissionOperated = null;
	private Persion myPersion = null;
	
	private PermissionOperated(){
		
	}
	
	public static PermissionOperated getInstance(){
		if (permissionOperated == null)
			permissionOperated = new PermissionOperated();
		
		return permissionOperated;
	}
	
	public boolean getPushOrdersPermission(){
		return true;
	}
	
	public boolean getGetOrdersPermission(){
		return true;
	}
	
	public Persion getMyPersion(){
		if (myPersion == null)
			myPersion = new Persion();
		
		return myPersion;
	}
}
