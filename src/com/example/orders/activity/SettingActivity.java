package com.example.orders.activity;

import com.example.orders.R;
import com.example.orders.setting.ExitFromSettingsActivity;
import com.example.orders.setting.InformationActivity;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class SettingActivity extends Activity {
	public static SettingActivity instance = null;
	private RelativeLayout gerenxinxi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		setContentView(R.layout.activity_setting);

		gerenxinxi = (RelativeLayout) findViewById(R.id.gerenxinxi);
		gerenxinxi.setOnClickListener(new MyButtonListener());
	}

	class MyButtonListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(SettingActivity.this, InformationActivity.class);
			SettingActivity.this.startActivity(intent);
		}
	}
}
