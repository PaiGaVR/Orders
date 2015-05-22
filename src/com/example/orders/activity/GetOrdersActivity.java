package com.example.orders.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.orders.R;
import com.example.orders.adapter.SwipeAdapter;
import com.example.orders.entity.PushOrders;
import com.example.orders.push.PusherReadGetterActivity;
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
				orders = new PushOrders("阿里巴巴", "sgsdhdftjhdjdyjtydkf",
						"1212-1245-4154");
				orders.setIcon_id(R.drawable.img_1);
			} else if (i % 3 == 1) {
				orders = new PushOrders("腾讯", "shgreshrtdjkyufliulu",
						"2016-54-121");
				orders.setIcon_id(R.drawable.img_2);
			} else {
				orders = new PushOrders("微信", "serhkiuliouytshtrdu", "2015-10-10");
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

			}
		});
	}

}
