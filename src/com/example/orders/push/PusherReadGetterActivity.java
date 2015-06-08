package com.example.orders.push;

import java.util.ArrayList;
import java.util.List;

import com.example.orders.R;
import com.example.orders.avatar.AvatarActivity;
import com.example.orders.chat.ChatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Window;

public class PusherReadGetterActivity extends Activity {

	private List<PusherGetGetter> data = new ArrayList<PusherGetGetter>();
	private PusherGetGetterListView mListView;

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
			PusherGetGetter orders = null;
			if (i % 3 == 0) {
				orders = new PusherGetGetter("张三", "123", "123", "123");
				orders.setIcon_id(R.drawable.img_1);
			} else if (i % 3 == 1) {
				orders = new PusherGetGetter("李四", "456", "456", "456");
				orders.setIcon_id(R.drawable.img_2);
			} else {
				orders = new PusherGetGetter("王五", "789", "789", "789");
				orders.setIcon_id(R.drawable.img_3);
			}

			data.add(orders);
		}
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		mListView = (PusherGetGetterListView) findViewById(R.id.pusher_choose_getter_list);
		PusherGetGetterAdapter mAdapter = new PusherGetGetterAdapter(this,
				data, mListView.getRightViewWidth());
		mAdapter.setOnItemClickListener(new PusherGetGetterAdapter.onItemClickListener() {

			@Override
			public void onItemClick() {
				Intent intent = new Intent();
				intent.setClass(PusherReadGetterActivity.this,
						ChatActivity.class);
				Bundle mBundle = new Bundle();    
                mBundle.putString("isRead", "true");//压入数据    
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
