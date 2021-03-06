package com.example.orders.avatar;

import java.util.List;

import com.example.orders.R;
import com.example.orders.dataoperated.OrdersOperated;

import android.os.Bundle;
import android.app.Activity;
import android.text.util.Linkify;
import android.view.Window;
import android.widget.TextView;

public class AvatarActivity extends Activity {

	private List<AvatarMessage> messageBoard = null;
	private AvatarMessageListView mListView;
	private AvatarAdapter aAdapter;

	private String avatarName;
	private String avatarGetNum;
	private String avatarPushNum;
	private String avatarGloryNum;
	private String avatarPhoneNum;

	private TextView avatar_examine_name;
	private TextView avatar_examine_get;
	private TextView avatar_examine_push;
	private TextView avatar_examine_glory;
	private TextView avatar_phone_num;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_avatar);

		avatarName = "人名";
		avatarGetNum = "100";
		avatarPushNum = "200";
		avatarGloryNum = "300";
		avatarPhoneNum = "18734818905";

		avatar_examine_name = (TextView) findViewById(R.id.avatar_examine_name);
		avatar_examine_get = (TextView) findViewById(R.id.avatar_examine_get);
		avatar_examine_push = (TextView) findViewById(R.id.avatar_examine_push);
		avatar_examine_glory = (TextView) findViewById(R.id.avatar_examine_glory);
		avatar_phone_num = (TextView) findViewById(R.id.avatar_phone_num);

		avatar_examine_name.setText(avatarName);
		avatar_examine_get.setText(avatarGetNum);
		avatar_examine_push.setText(avatarPushNum);
		avatar_examine_glory.setText(avatarGloryNum);
		avatar_phone_num.setText(avatarPhoneNum);

		// 设置拨打电话链接
		Linkify.addLinks(avatar_phone_num, Linkify.PHONE_NUMBERS);
		initView();
	}

	private void initView() {
		messageBoard = OrdersOperated.getInstance().getMessageBoardList();
		mListView = (AvatarMessageListView) findViewById(R.id.avatar_message_list);
		aAdapter = new AvatarAdapter(this, messageBoard);
		mListView.setAdapter(aAdapter);
	}

	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}

	public String getAvatarGetNum() {
		return avatarGetNum;
	}

	public void setAvatarGetNum(String avatarGetNum) {
		this.avatarGetNum = avatarGetNum;
	}

	public String getAvatarPushNum() {
		return avatarPushNum;
	}

	public void setAvatarPushNum(String avatarPushNum) {
		this.avatarPushNum = avatarPushNum;
	}

	public String getAvatarGloryNum() {
		return avatarGloryNum;
	}

	public void setAvatarGloryNum(String avatarGloryNum) {
		this.avatarGloryNum = avatarGloryNum;
	}
}
