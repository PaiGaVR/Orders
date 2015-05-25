package com.example.orders.activity;

import com.example.orders.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class OrderProcessActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.order_process);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.order_process, menu);
		return true;
	}

}
