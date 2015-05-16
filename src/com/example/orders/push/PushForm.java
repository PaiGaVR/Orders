package com.example.orders.push;

import com.example.orders.R;
import com.example.orders.R.layout;
import com.example.orders.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PushForm extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_push_form);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.push_form, menu);
		return true;
	}

}
