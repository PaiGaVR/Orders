package com.example.orders.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.orders.R;
import com.example.orders.avatar.AvatarActivity;
import com.example.orders.get.GetterGetOrders;
import com.example.orders.get.GetterGetOrdersAdapter;
import com.example.orders.get.GetterGetOrdersListView;
import com.example.orders.get.GetterReadOrderActivity;
import com.example.orders.push.PusherGetGetterAdapter;
import com.example.orders.push.PusherReadGetterActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class GetOrdersActivity extends Activity {

	private List<GetterGetOrders> data = new ArrayList<GetterGetOrders>();
	private GetterGetOrdersListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_orders);
		initData();
		initView();
	}

	private void initData() {

		for (int i = 0; i < 100; i++) {
			GetterGetOrders orders = null;
			if (i % 3 == 0) {
				orders = new GetterGetOrders("张三", "明天", "小店", "200", "送饭");
				orders.setIcon_id(R.drawable.img_1);
			} else if (i % 3 == 1) {
				orders = new GetterGetOrders("李四", "后天", "北京", "400", "约会");
				orders.setIcon_id(R.drawable.img_2);
			} else {
				orders = new GetterGetOrders("王五", "三天后", "天津", "500", "排队");
				orders.setIcon_id(R.drawable.img_3);
			}

			data.add(orders);
		}
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		mListView = (GetterGetOrdersListView) findViewById(R.id.getter_get_orders_list);
		GetterGetOrdersAdapter mAdapter = new GetterGetOrdersAdapter(this,
				data, mListView.getRightViewWidth());
		mAdapter.setOnItemClickListener(new GetterGetOrdersAdapter.onItemClickListener() {

			@Override
			public void onItemClick() {
				Intent intent = new Intent();
				intent.setClass(GetOrdersActivity.this,
						GetterReadOrderActivity.class);
				GetOrdersActivity.this.startActivity(intent);
			}
		});

		mAdapter.setOnClickListener(new GetterGetOrdersAdapter.onAvatarClickListener() {

			@Override
			public void onAvatarClick() {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(GetOrdersActivity.this, AvatarActivity.class);
				GetOrdersActivity.this.startActivity(intent);
			}
		});
		mListView.setAdapter(mAdapter);
	}
}
