package com.example.orders.setting;

import com.example.orders.R;
import com.example.orders.R.layout;
import com.example.orders.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class NotificationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting_notification);
	}

}
