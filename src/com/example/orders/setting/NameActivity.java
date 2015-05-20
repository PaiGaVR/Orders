package com.example.orders.setting;

import com.example.orders.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

public class NameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting_name);
	}

}
