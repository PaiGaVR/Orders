package com.example.orders.activity;

import com.example.orders.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReadOrdersActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_orders);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.read_orders, menu);
		return true;
	}

}
