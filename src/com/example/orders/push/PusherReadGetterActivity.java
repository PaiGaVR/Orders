package com.example.orders.push;

import java.util.ArrayList;
import java.util.List;

import com.example.order.chat.PusherChatActivity;
import com.example.orders.R;
import com.example.orders.adapter.SwipeAdapter;
import com.example.orders.entity.PushOrders;
import com.example.orders.widgets.PushOrdersListView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Toast;

public class PusherReadGetterActivity extends Activity {

	private List<PushOrders> data = new ArrayList<PushOrders>();
	private PushOrdersListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pusher_read_getter);
		initData();
		initView();
	}

	private void initData() {

		for (int i = 0; i < 100; i++) {
			PushOrders orders = null;
			if (i % 3 == 0) {
				orders = new PushOrders("张三", "123   123   123", "");
				orders.setIcon_id(R.drawable.img_1);
			} else if (i % 3 == 1) {
				orders = new PushOrders("李四", "456   456   456", "");
				orders.setIcon_id(R.drawable.img_2);
			} else {
				orders = new PushOrders("王五", "789   789   789", "");
				orders.setIcon_id(R.drawable.img_3);
			}

			data.add(orders);
		}
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		mListView = (PushOrdersListView) findViewById(R.id.pusher_choose_getter_list);
		SwipeAdapter mAdapter = new SwipeAdapter(this, data,
				mListView.getRightViewWidth());

		mAdapter.setOnRightItemClickListener(new SwipeAdapter.onRightItemClickListener() {

			@Override
			public void onRightItemClick(View v, int position) {

				Toast.makeText(PusherReadGetterActivity.this,
						"删除第  " + (position + 1) + " 对话记录", Toast.LENGTH_SHORT)
						.show();
			}
		});

		mListView.setAdapter(mAdapter);

		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent();
				intent.setClass(PusherReadGetterActivity.this,
						PusherChatActivity.class);
				PusherReadGetterActivity.this.startActivity(intent);
			}
		});
	}

}
