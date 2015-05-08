package com.example.orders.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.orders.R;
import com.example.orders.entity.PushOrders;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PushOrdersActivity extends Activity {

	private List<PushOrders> data = new ArrayList<PushOrders>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_push_orders);
		
		initData();
	}

	private void initData() {
		
    	for(int i=0;i<50;i++){
    		PushOrders orders = null;
    		if(i%3==0){
    			orders = new PushOrders("腾讯新闻", "人民日报刊文：习近平对评价毛泽东�?6个重要观�?", "早上8:44");
    			orders.setIcon_id(R.drawable.img_1);
    		}else if(i%3==1){
    			orders = new PushOrders("订阅�?", "CSDN�?2013年国内最具技术影响力公司","早上8:49");
    			orders.setIcon_id(R.drawable.img_2);
    		}else{
    			orders = new PushOrders("微博阅读", "美女演各款妹子跟男朋友打电话","昨天晚上");
    			orders.setIcon_id(R.drawable.img_3);
    		}
    		
    		data.add(orders);
    	}
	}

}
