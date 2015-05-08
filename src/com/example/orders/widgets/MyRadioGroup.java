package com.example.orders.widgets;

import com.example.orders.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class MyRadioGroup extends RadioGroup {
	public MyRadioGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
public class CheckListener implements OnCheckedChangeListener{
    	
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			switch(arg1){
				case R.id.tab_icon_push_orders : {
					
					break;
				}
				case R.id.tab_icon_get_orders : {
					
					break;
				}
				case R.id.tab_icon_read_orders : {
					
					break;
				}
				case R.id.tab_icon_setting : {
					
					break;
				}
			}
		}
    }
}
