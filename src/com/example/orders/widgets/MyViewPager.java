package com.example.orders.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager{

	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	private boolean canScroll = true;
	
	public void canScoll(boolean flag){
		this.canScroll = flag;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		if (canScroll){
			return super.onInterceptTouchEvent(arg0);
		} else {
			return false;
		}
	}
}
