package com.example.orders.activity;

import com.example.orders.R;
import com.example.orders.setting.AboutActivity;
import com.example.orders.setting.BlacklistActivity;
import com.example.orders.setting.ExitFromSettingsActivity;
import com.example.orders.setting.HelpActivity;
import com.example.orders.setting.InformationActivity;
import com.example.orders.setting.NotificationActivity;
import com.example.orders.setting.PrefectInformationActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.app.Activity;
import android.content.Intent;

public class SettingActivity extends Activity {
	public static SettingActivity instance = null;
	private RelativeLayout gerenxinxi;
	private Button dialog_exit;
	private RelativeLayout guanyu;
	private RelativeLayout xitongtongzhi;
	private RelativeLayout heimingdan;
	private RelativeLayout bangzhuyufankui;
	private RelativeLayout wanshanxinxi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		setContentView(R.layout.activity_setting);

		// 个人信息
		gerenxinxi = (RelativeLayout) findViewById(R.id.gerenxinxi);
		gerenxinxi.setOnClickListener(new MyButtonListener());

		// 退出
		dialog_exit = (Button) findViewById(R.id.dialog_exit);
		dialog_exit.setOnClickListener(new MyExitButtonListener());

		// 黑名单
		heimingdan = (RelativeLayout) findViewById(R.id.heimingdan);
		heimingdan.setOnClickListener(new HeiMingDanListener());

		// 帮助反馈
		bangzhuyufankui = (RelativeLayout) findViewById(R.id.bangzhuyufankui);
		bangzhuyufankui.setOnClickListener(new BangZhuYuFanKuiListener());

		// 通知
		xitongtongzhi = (RelativeLayout) findViewById(R.id.xitongtongzhi);
		xitongtongzhi.setOnClickListener(new MyXiTongTongZhiListener());

		// 关于
		guanyu = (RelativeLayout) findViewById(R.id.guanyu);
		guanyu.setOnClickListener(new MyGuanYuListener());

		// 完善信息
		wanshanxinxi = (RelativeLayout) findViewById(R.id.wanshanxinxi);
		wanshanxinxi.setOnClickListener(new MyWanShanXinXiListener());
	}

	class MyButtonListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, InformationActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}

	class BangZhuYuFanKuiListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, HelpActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}

	class HeiMingDanListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, BlacklistActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}

	class MyExitButtonListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this,
					ExitFromSettingsActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}

	class MyXiTongTongZhiListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, NotificationActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}

	class MyGuanYuListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, AboutActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}

	class MyWanShanXinXiListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this,
					PrefectInformationActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}
}
