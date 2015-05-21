package com.example.orders.setting;

import com.example.orders.R;
import com.example.orders.activity.SettingActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelpActivity extends Activity {

	private Button setting_help_submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting_help);
		setting_help_submit = (Button) findViewById(R.id.setting_help_submit);
		setting_help_submit.setOnClickListener(new HelpSubmitListener());

	}

	class HelpSubmitListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(HelpActivity.this, SettingActivity.class);
			HelpActivity.this.startActivity(intent);
			HelpActivity.this.finish();
		}
	}
}
