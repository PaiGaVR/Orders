package com.example.orders.activity;

import com.example.orders.R;
import com.example.orders.setting.InformationActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class SettingActivity extends Activity {
	public static SettingActivity instance = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		setContentView(R.layout.activity_setting);
		TextView txtViewRegister = (TextView)findViewById(R.id.gerenxinxi);
		txtViewRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				Intent intent = new Intent(SettingActivity.this,InformationActivity.class);
				startActivity(intent);
			}
			});
		}
	}
	

	

