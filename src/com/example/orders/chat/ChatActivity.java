package com.example.orders.chat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.orders.R;
import com.example.orders.activity.OrderProcessActivity;
import com.example.orders.avatar.AvatarActivity;
import com.example.orders.chat.util.ChatMsgEntity;
import com.example.orders.chat.util.ChatMsgViewAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableRow;

public class ChatActivity extends Activity implements OnClickListener {
	private Button mBtnSend;
	private EditText mEditTextContent;
	private ChatMsgViewAdapter mAdapter;
	private ListView mListView;
	private List<ChatMsgEntity> mDataArrays = new ArrayList<ChatMsgEntity>();
	private Button function_order_add;
	private Button funtionButton;
	private Button function_oeder_process;
	private ImageButton chat_imageButton1;
	private RelativeLayout rl_bottom_down;
	public String isRead;
	private boolean isShow = false;
	public TableRow tableRow_function_button;
	private String addMoney;
	private String addReason;
	private String contString;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chatting_activity_pusher);
		initView();
		initData();

		function_order_add = (Button) findViewById(R.id.function_order_add);
		function_order_add.setOnClickListener(new AddListener());

		chat_imageButton1 = (ImageButton) findViewById(R.id.chat_imageButton1);
		chat_imageButton1.setOnClickListener(new AvatarListener());

		rl_bottom_down = (RelativeLayout) findViewById(R.id.rl_bottom_down);
		Bundle bundle = getIntent().getExtras(); // 得到传过来的bundle
		isRead = bundle.getString("isRead");// 读出数据

		if (isRead.equals("false")) {
			rl_bottom_down.setVisibility(View.GONE);
		} else {
			rl_bottom_down.setVisibility(View.VISIBLE);
		}

		tableRow_function_button = (TableRow) findViewById(R.id.tableRow_function_button);
		tableRow_function_button.setVisibility(View.GONE);

		funtionButton = (Button) findViewById(R.id.funtionButton);
		funtionButton.setOnClickListener(new ShowFunctionButtonListener());

		function_oeder_process = (Button) findViewById(R.id.function_oeder_process);
		function_oeder_process.setOnClickListener(new LookOrderListener());
	}

	public class LookOrderListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(ChatActivity.this, OrderProcessActivity.class);
			ChatActivity.this.startActivity(intent);
		}
	}

	public class ShowFunctionButtonListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (isShow) {
				tableRow_function_button.setVisibility(View.GONE);
				isShow = false;
			} else {
				tableRow_function_button.setVisibility(View.VISIBLE);
				isShow = true;
			}
		}
	}

	public class AddListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivityForResult(new Intent(ChatActivity.this,
					AddMoneyActivity.class), 10000);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (null != data && resultCode == Activity.RESULT_OK) {
			addMoney = data.getStringExtra("add_M");
			addReason = data.getStringExtra("add_R");
			if (addMoney != null && addReason != null) {
				contString = "   " + "重要信息:" + '\n' + "   " + "修改金额:"
						+ addMoney + '\n' + "   " + "修改原因:" + addReason;
				send(contString, false, true);
			}
		}
		tableRow_function_button.setVisibility(View.GONE);
	}

	public class AvatarListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(ChatActivity.this, AvatarActivity.class);
			ChatActivity.this.startActivity(intent);
		}
	}

	private void initView() {
		mListView = (ListView) findViewById(R.id.chat_listview);
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
				entity.setMsgTypeImport(false);
			} else {
				entity.setName("接单");
				entity.setMsgType(true);
				entity.setMsgTypeImport(false);
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
			send(mEditTextContent.getText().toString(), false, false);
			break;
		}
	}

	private void send(String s, boolean type, boolean typeImport) {
		if (s.length() > 0) {

			ChatMsgEntity entity = new ChatMsgEntity();
			entity.setDate(getDate());
			entity.setName("下单");
			entity.setMsgType(type);
			entity.setMsgTypeImport(typeImport);
			entity.setText(s);

			mDataArrays.add(entity);
			mAdapter.notifyDataSetChanged();
			mEditTextContent.setText("");
			mListView.setSelection(mListView.getCount());
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
