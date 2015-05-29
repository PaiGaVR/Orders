package com.example.orders.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.orders.R;
import com.example.orders.dataoperated.ResultCode;
import com.example.orders.fragment.GetOrdersFragment;
import com.example.orders.fragment.PushOrdersFragment;
import com.example.orders.fragment.ReadOrdersFragment;
import com.example.orders.push.PushFormActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments = new ArrayList<Fragment>();
	private RadioGroup radioGroup;
	private TextView headText;
	
	private PushOrdersFragment push;
	private GetOrdersFragment get;
	private ReadOrdersFragment read;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initMenu();
		initViewPager();
	}

	private void initViewPager() {
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		radioGroup = (RadioGroup) findViewById(R.id.tab_bar);
		headText = (TextView) findViewById(R.id.head_text);
		
		push = new PushOrdersFragment();
		get = new GetOrdersFragment();
		read = new ReadOrdersFragment();
		
		mFragments.add(push);
		mFragments.add(get);
		mFragments.add(read);

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public int getCount() {
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return mFragments.get(arg0);
			}
		};

		mViewPager.setAdapter(mAdapter);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				((RadioButton) radioGroup.getChildAt(mViewPager
						.getCurrentItem())).setChecked(true);
				
				switch (mViewPager.getCurrentItem()) {
				case 0:
					headText.setText("下单");
					break;
				case 1:
					headText.setText("接单");
					break;
				case 2:
					headText.setText("查单");
					break;
				}
			}
		});
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (null != data && resultCode == ResultCode.PUSH_ORDERS) {
			push.addOrder(data);
		}
	}

	private void initMenu() {
		setBehindContentView(R.layout.left_menu_frame);

		SlidingMenu menu = getSlidingMenu();
		menu.setMode(SlidingMenu.LEFT_RIGHT);

		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);

		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);

		menu.setFadeDegree(0.35f);
		menu.setBehindScrollScale(0.5f);
		menu.setSecondaryShadowDrawable(R.drawable.shadow);

		menu.setSecondaryMenu(R.layout.right_menu_frame);
	}
	
	public ViewPager getViewPager(){
		return mViewPager;
	}

	public void showLeftMenu(View view) {
		getSlidingMenu().showMenu();
	}

	public void showRightMenu(View view) {
		getSlidingMenu().showSecondaryMenu();
	}

	public void showFirstFragment(View view) {
		mViewPager.setCurrentItem(0);
		headText.setText("下单");
	}

	public void showSecondFragment(View view) {
		mViewPager.setCurrentItem(1);
		headText.setText("接单");
	}

	public void showLastFragment(View view) {
		mViewPager.setCurrentItem(2);
		headText.setText("查单");
	}
	
	public void openAddOrderForm(View view) {
		startActivityForResult(new Intent(this,
				PushFormActivity.class), 10000);
	}
}
