package com.example.orders.activity;

import com.example.orders.R;
import com.example.orders.setting.AboutActivity;
import com.example.orders.setting.BlacklistActivity;
import com.example.orders.setting.ExitFromSettingsActivity;
import com.example.orders.setting.HelpActivity;
import com.example.orders.setting.InformationActivity;
import com.example.orders.setting.NotificationActivity;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		setContentView(R.layout.activity_setting);

		gerenxinxi = (RelativeLayout) findViewById(R.id.gerenxinxi);
		gerenxinxi.setOnClickListener(new MyButtonListener());

		dialog_exit = (Button) findViewById(R.id.dialog_exit);
		dialog_exit.setOnClickListener(new MyExitButtonListener());

		heimingdan= (RelativeLayout) findViewById(R.id.heimingdan);
		heimingdan.setOnClickListener(new HeiMingDanListener());
		
		bangzhuyufankui = (RelativeLayout) findViewById(R.id.bangzhuyufankui);
		bangzhuyufankui.setOnClickListener(new BangZhuYuFanKuiListener());
		
		xitongtongzhi = (RelativeLayout) findViewById(R.id.xitongtongzhi);
		xitongtongzhi.setOnClickListener(new MyXiTongTongZhiListener());

		guanyu = (RelativeLayout) findViewById(R.id.guanyu);
		guanyu.setOnClickListener(new MyGuanYuListener());
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
			intent.setClass(SettingActivity.this,
					HelpActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}
	
	
	class HeiMingDanListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this,
					BlacklistActivity.class);
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
}
