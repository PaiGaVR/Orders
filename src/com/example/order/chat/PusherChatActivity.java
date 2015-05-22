package com.example.order.chat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.order.chat.util.ChatMsgEntity;
import com.example.order.chat.util.ChatMsgViewAdapter;
import com.example.orders.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class PusherChatActivity extends Activity implements OnClickListener {
	private Button mBtnSend;
	private EditText mEditTextContent;
	private ChatMsgViewAdapter mAdapter;
	private ListView mListView;
	private List<ChatMsgEntity> mDataArrays = new ArrayList<ChatMsgEntity>();
	private Button funtionButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chatting_activity_pusher);
		initView();
		initData();
		
		funtionButton = (Button) findViewById(R.id.funtionButton);
		funtionButton.setOnClickListener(new AddListener());
	}

	public class AddListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(PusherChatActivity.this, AddMoneyActivity.class);
			PusherChatActivity.this.startActivity(intent);
			PusherChatActivity.this.finish();
		}
	}
	
	private void initView() {
		mListView = (ListView) findViewById(R.id.listview);
		mBtnSend = (Button) findViewById(R.id.btn_send);
		mBtnSend.setOnClickListener(this);
		mEditTextContent = (EditText) findViewById(R.id.et_sendmessage);
	}

	private String[] msgArray = new String[] { "在么？", "在，怎么了？", "干么呢？", "不干吗",
			"哦", "。。。", "拜拜", "拜拜" };

	private String[] dataArray = new String[] { "2015-05-15 18:00",
			"2015-05-15 18:10", "2015-05-15 18:11", "2015-05-15 18:20",
			"2015-05-15 18:30", "2015-05-15 18:35", "2015-05-15 18:40",
			"2015-05-15 18:50" };
	private int COUNT = msgArray.length;

	private void initData() {
		for (int i = 0; i < COUNT; i++) {
			ChatMsgEntity entity = new ChatMsgEntity();
			entity.setDate(dataArray[i]);
			if (i % 2 == 0) {
				entity.setName("下单");
				entity.setMsgType(false);
			} else {
				entity.setName("接单");
				entity.setMsgType(true);
			}

			entity.setText(msgArray[i]);
			mDataArrays.add(entity);
		}
		mAdapter = new ChatMsgViewAdapter(this, mDataArrays);
		mListView.setAdapter(mAdapter);
	}

	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btn_send:
			send();
			break;
		}
	}

	private void send() {
		String contString = mEditTextContent.getText().toString();
		if (contString.length() > 0) {
			ChatMsgEntity entity = new ChatMsgEntity();
			entity.setDate(getDate());
			entity.setName("");
			entity.setMsgType(false);
			entity.setText(contString);
			mDataArrays.add(entity);
			mAdapter.notifyDataSetChanged();
			mEditTextContent.setText("");
			mListView.setSelection(mListView.getCount() - 1);
		}
	}

	private String getDate() {
		Calendar c = Calendar.getInstance();
		String year = String.valueOf(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH));
		String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + 1);
		String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		String mins = String.valueOf(c.get(Calendar.MINUTE));
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append(year + "-" + month + "-" + day + " " + hour + ":"
				+ mins);
		return sbBuffer.toString();
	}
}
