package com.example.orders.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.orders.R;
import com.example.orders.avatar.AvatarActivity;
import com.example.orders.read.ReadOrderdAdapter;
import com.example.orders.read.ReadOrders;
import com.example.orders.read.ReadOrdersListView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RadioButton;

public class ReadOrdersActivity extends Activity {

	private List<ReadOrders> data = new ArrayList<ReadOrders>();
	private ReadOrdersListView mListView;
	private boolean isOver = false;

	private RadioButton read_is_going;
	private RadioButton read_is_over;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_read_orders);
		read_is_going = (RadioButton) findViewById(R.id.read_is_going);
		read_is_over = (RadioButton) findViewById(R.id.read_is_over);
		read_is_going.setOnClickListener(new IsGoingListener());
		read_is_over.setOnClickListener(new IsOverListener());
		initData();
		initView();
	}

	class IsGoingListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			isOver = false;
			data.clear();
			initData();
			initView();
		}
	}

	class IsOverListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			data.clear();
			isOver = true;
			initData();
			initView();
		}
	}

	private void initData() {
		if (!isOver) {
			for (int i = 0; i < 100; i++) {
				ReadOrders orders = null;
				if (i % 3 == 0) {
					orders = new ReadOrders("送饭", "张三", "200", "明天");
					orders.setIcon_id(R.drawable.img_1);
				} else if (i % 3 == 1) {
					orders = new ReadOrders("约会", "李四", "400", "后天");
					orders.setIcon_id(R.drawable.img_5);
				} else {
					orders = new ReadOrders("排队", "王五", "500", "三天后");
					orders.setIcon_id(R.drawable.img_4);
				}

				data.add(orders);
			}
		} else {
			for (int i = 0; i < 100; i++) {
				ReadOrders orders = null;
				if (i % 3 == 0) {
					orders = new ReadOrders("送水", "张三", "521", "2011-9");
					orders.setIcon_id(R.drawable.img_1);
				} else if (i % 3 == 1) {
					orders = new ReadOrders("电影", "李四", "15540", "2014-5");
					orders.setIcon_id(R.drawable.img_2);
				} else {
					orders = new ReadOrders("吃饭", "王五", "2211", "2015-11");
					orders.setIcon_id(R.drawable.img_3);
				}
				data.add(orders);
			}
		}
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		mListView = (ReadOrdersListView) findViewById(R.id.read_going_or_over_orders_list);
		ReadOrderdAdapter mAdapter = new ReadOrderdAdapter(this, data,
				mListView.getRightViewWidth());
		mAdapter.setOnItemClickListener(new ReadOrderdAdapter.onItemClickListener() {

			@Override
			public void onItemClick() {

			}
		});

		mAdapter.setOnClickListener(new ReadOrderdAdapter.onAvatarClickListener() {

			@Override
			public void onAvatarClick() {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(ReadOrdersActivity.this, AvatarActivity.class);
				ReadOrdersActivity.this.startActivity(intent);
			}
		});
		mListView.setAdapter(mAdapter);
	}
}
