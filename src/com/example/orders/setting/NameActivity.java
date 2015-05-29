package com.example.orders.setting;

import com.example.orders.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NameActivity extends Activity {

	private Button setting_nicheng_submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting_name);

		setting_nicheng_submit = (Button) findViewById(R.id.setting_nicheng_submit);
		setting_nicheng_submit.setOnClickListener(new NiChengSubmitListener());
	}

	class NiChengSubmitListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(NameActivity.this, InformationActivity.class);
			NameActivity.this.startActivity(intent);
			NameActivity.this.finish();
		}
	}
}
