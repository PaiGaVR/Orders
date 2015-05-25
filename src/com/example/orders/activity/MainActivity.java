package com.example.orders.activity;

import com.example.orders.R;
import android.os.Bundle;
import android.app.ActivityGroup;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup {
	public static MainActivity instance = null;
	private TabHost tab_host;
	private RadioGroup main_radio_group;
	private Button setButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		tab_host = (TabHost) findViewById(R.id.my_tab);
		tab_host.setup();
		tab_host.setup(this.getLocalActivityManager());
		tab_host.addTab(tab_host.newTabSpec("tag1").setIndicator("0")
				.setContent(new Intent(this, PushOrdersActivity.class)));
		tab_host.addTab(tab_host.newTabSpec("tag2").setIndicator("1")
				.setContent(new Intent(this, GetOrdersActivity.class)));
		tab_host.addTab(tab_host.newTabSpec("tag3").setIndicator("2")
				.setContent(new Intent(this, ReadOrdersActivity.class)));

		main_radio_group = (RadioGroup) findViewById(R.id.my_radio_bar);

		CheckListener checkListener = new CheckListener();
		main_radio_group.setOnCheckedChangeListener(checkListener);

		setButton = (Button) findViewById(R.id.set_button);
		setButton.setOnClickListener(new SetListener());
	}

	class SetListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, SettingActivity.class);
			MainActivity.this.startActivity(intent);
		}
	}

	public class CheckListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			switch (arg1) {
			case R.id.tab_icon_push_orders: {
				tab_host.setCurrentTab(0);
				break;
			}
			case R.id.tab_icon_get_orders: {
				tab_host.setCurrentTab(1);
				break;
			}
			case R.id.tab_icon_read_orders: {
				tab_host.setCurrentTab(2);
				break;
			}
			}
		}
	}
}
