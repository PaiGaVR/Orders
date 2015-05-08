package com.example.orders.activity;

import com.example.orders.R;

import android.os.Bundle;
import android.app.ActivityGroup;
import android.content.Intent;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup {
	private TabHost tab_host;
	private RadioGroup main_radio_group;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		tab_host = (TabHost) findViewById(R.id.my_tab);
		tab_host.setup();
		tab_host.setup(this.getLocalActivityManager());
		tab_host.addTab(tab_host.newTabSpec("tag1").setIndicator("0").setContent(new Intent(this, PushOrdersActivity.class)));
        tab_host.addTab(tab_host.newTabSpec("tag2").setIndicator("1").setContent(new Intent(this, GetOrdersActivity.class)));
        tab_host.addTab(tab_host.newTabSpec("tag3").setIndicator("2").setContent(new Intent(this, ReadOrdersActivity.class)));
        tab_host.addTab(tab_host.newTabSpec("tag4").setIndicator("3").setContent(new Intent(this, SettingActivity.class)));
        
        main_radio_group = (RadioGroup) findViewById(R.id.my_radio_bar);
        
        CheckListener checkListener = new CheckListener();
        main_radio_group.setOnCheckedChangeListener(checkListener);
	}
	
public class CheckListener implements OnCheckedChangeListener{
    	
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			switch(arg1){
				case R.id.tab_icon_push_orders : {
					tab_host.setCurrentTab(0);
					break;
				}
				case R.id.tab_icon_get_orders : {
					tab_host.setCurrentTab(1);
					break;
				}
				case R.id.tab_icon_read_orders : {
					tab_host.setCurrentTab(2);
					break;
				}
				case R.id.tab_icon_setting : {
					tab_host.setCurrentTab(3);
					break;
				}
			}
		}
    }
}
