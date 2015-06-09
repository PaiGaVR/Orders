package com.example.orders.push;

import java.util.List;

import com.example.orders.R;
import com.example.orders.avatar.AvatarActivity;
import com.example.orders.chat.ChatActivity;
import com.example.orders.dataoperated.OrdersOperated;
import com.example.orders.entity.Orders;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.widget.EditText;

public class PusherReadGetterActivity extends Activity {

	private List<PusherGetGetter> getterList = null;
	private PusherGetGetterListView mListView;
	private EditText orders_content = null;
	private String orderContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_pusher_read_getter);
		orders_content = (EditText) findViewById(R.id.orders_content);
		orders_content.setText(orderContent);
		initView();
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		getterList = OrdersOperated.getInstance().getGetterList();
		mListView = (PusherGetGetterListView) findViewById(R.id.pusher_choose_getter_list);
		PusherGetGetterAdapter mAdapter = new PusherGetGetterAdapter(this,
				getterList, mListView.getRightViewWidth());
		mAdapter.setOnItemClickListener(new PusherGetGetterAdapter.onItemClickListener() {

			@Override
			public void onItemClick() {
				Intent intent = new Intent();
				intent.setClass(PusherReadGetterActivity.this,
						ChatActivity.class);
				Bundle mBundle = new Bundle();
				mBundle.putString("isRead", "true");// 压入数据
				intent.putExtras(mBundle);
				PusherReadGetterActivity.this.startActivity(intent);
			}
		});

		mAdapter.setOnClickListener(new PusherGetGetterAdapter.onAvatarClickListener() {

			@Override
			public void onAvatarClick() {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(PusherReadGetterActivity.this,
						AvatarActivity.class);
				PusherReadGetterActivity.this.startActivity(intent);
			}
		});
		mListView.setAdapter(mAdapter);
	}
}
