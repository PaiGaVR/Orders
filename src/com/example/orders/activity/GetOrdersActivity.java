package com.example.orders.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.order.chat.GetterChatActivity;
import com.example.orders.R;
import com.example.orders.adapter.SwipeAdapter;
import com.example.orders.entity.PushOrders;
import com.example.orders.widgets.PushOrdersListView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class GetOrdersActivity extends Activity {

	private List<PushOrders> data = new ArrayList<PushOrders>();
	private PushOrdersListView mListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_orders);
		initData();
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_orders, menu);
		return true;
	}

	private void initData() {

		for (int i = 0; i < 100; i++) {
			PushOrders orders = null;
			if (i % 3 == 0) {
				orders = new PushOrders("腾讯新闻", "abcdefghijklmnopqrstuvwsyz",
						"早上8:44");
				orders.setIcon_id(R.drawable.img_1);
			} else if (i % 3 == 1) {
				orders = new PushOrders("订阅", "1234567890",
						"早上8:49");
				orders.setIcon_id(R.drawable.img_2);
			} else {
				orders = new PushOrders("微博阅读", "啊哦额嘿嗯呐呀duangduangduang", "昨天晚上");
				orders.setIcon_id(R.drawable.img_3);
			}

			data.add(orders);
		}
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		mListView = (PushOrdersListView) findViewById(R.id.get_orders_list);
		SwipeAdapter mAdapter = new SwipeAdapter(this, data,
				mListView.getRightViewWidth());

		mAdapter.setOnRightItemClickListener(new SwipeAdapter.onRightItemClickListener() {

			@Override
			public void onRightItemClick(View v, int position) {

				Toast.makeText(GetOrdersActivity.this,
						"删除第  " + (position + 1) + " 对话记录", Toast.LENGTH_SHORT)
						.show();
			}
		});

		mListView.setAdapter(mAdapter);

		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				/*
				 * Toast.makeText(PushOrdersActivity.this, "点击 " + position,
				 * Toast.LENGTH_SHORT).show();
				 */

				Intent intent = new Intent();
				intent.setClass(GetOrdersActivity.this,
						GetterChatActivity.class);
				GetOrdersActivity.this.startActivity(intent);
			}
		});
	}

}
