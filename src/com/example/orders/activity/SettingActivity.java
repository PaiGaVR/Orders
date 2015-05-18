package com.example.orders.activity;

import com.example.orders.R;
import com.example.orders.setting.AboutActivity;
import com.example.orders.setting.ExitFromSettingsActivity;
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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		setContentView(R.layout.activity_setting);

		gerenxinxi = (RelativeLayout) findViewById(R.id.gerenxinxi);
		gerenxinxi.setOnClickListener(new MyButtonListener());
		
		dialog_exit = (Button) findViewById(R.id.dialog_exit);
		dialog_exit.setOnClickListener(new MyExitButtonListener());
		
		guanyu = (RelativeLayout) findViewById(R.id.guanyu);
		guanyu.setOnClickListener(new MyGuanYuListener());
		
		xitongtongzhi = (RelativeLayout) findViewById(R.id.xitongtongzhi);
		xitongtongzhi.setOnClickListener(new MyXiTongTongZhiListener());
	}

	class MyButtonListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, InformationActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}
	
	class MyExitButtonListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, ExitFromSettingsActivity.class);
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
