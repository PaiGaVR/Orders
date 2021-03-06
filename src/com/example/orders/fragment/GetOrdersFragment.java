package com.example.orders.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.orders.R;
import com.example.orders.avatar.AvatarActivity;
import com.example.orders.dataoperated.OrdersOperated;
import com.example.orders.entity.Orders;
import com.example.orders.get.GetterGetOrdersAdapter;
import com.example.orders.get.GetterGetOrdersListView;
import com.example.orders.get.GetterReadOrderActivity;
import com.example.orders.get.widget.AbstractSpinerAdapter;
import com.example.orders.get.widget.SpinerPopWindow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;

public class GetOrdersFragment extends Fragment implements OnClickListener,
		AbstractSpinerAdapter.IOnItemSelectListener {

	private List<Orders> getOrdersList;
	private GetterGetOrdersListView mListView;
	private GetterGetOrdersAdapter mAdapter = null;
	private List<String> rank_timeList = new ArrayList<String>();
	private SpinerPopWindow rank_timePopWindow;
	private List<String> rank_distanceList = new ArrayList<String>();
	private SpinerPopWindow rank_distancePopWindow;
	private List<String> rank_moneyList = new ArrayList<String>();
	private SpinerPopWindow rank_moneyPopWindow;
	private List<String> rank_gloryList = new ArrayList<String>();
	private SpinerPopWindow rank_gloryPopWindow;
	private TextView timeTView;
	private TextView distanceTView;
	private TextView moneyTView;
	private TextView gloryTView;
	private LinearLayout rank_time_layout;
	private LinearLayout rank_distance_layout;
	private LinearLayout rank_money_layout;
	private LinearLayout rank_glory_layout;

	private int rankType = 0;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_get_orders, container,
				false);

		initView(view);
		return view;
	}

	/**
	 * 初始化界面
	 */
	private void initView(View view) {

		rank_time_layout = (LinearLayout) view
				.findViewById(R.id.rank_time_layout);
		timeTView = (TextView) view.findViewById(R.id.rank_time_select);
		rank_time_layout.setOnClickListener(this);
		//
		rank_distance_layout = (LinearLayout) view
				.findViewById(R.id.rank_distance_layout);
		distanceTView = (TextView) view.findViewById(R.id.rank_distance_select);
		rank_distance_layout.setOnClickListener(this);
		//
		rank_money_layout = (LinearLayout) view
				.findViewById(R.id.rank_money_layout);
		moneyTView = (TextView) view.findViewById(R.id.rank_money_select);
		rank_money_layout.setOnClickListener(this);
		//
		rank_glory_layout = (LinearLayout) view
				.findViewById(R.id.rank_glory_layout);
		gloryTView = (TextView) view.findViewById(R.id.rank_glory_select);
		rank_glory_layout.setOnClickListener(this);

		String[] times = getResources().getStringArray(R.array.rank_time);
		for (int i = 0; i < times.length; i++) {
			rank_timeList.add(times[i]);
		}
		String[] distances = getResources().getStringArray(
				R.array.rank_distance);
		for (int i = 0; i < distances.length; i++) {
			rank_distanceList.add(distances[i]);
		}
		String[] moneys = getResources().getStringArray(R.array.rank_money);
		for (int i = 0; i < moneys.length; i++) {
			rank_moneyList.add(moneys[i]);
		}
		String[] glorys = getResources().getStringArray(R.array.rank_glory);
		for (int i = 0; i < glorys.length; i++) {
			rank_gloryList.add(glorys[i]);
		}

		rank_timePopWindow = new SpinerPopWindow(getActivity());
		rank_timePopWindow.refreshData(rank_timeList, 0);
		rank_timePopWindow.setRankItemListener(this);

		rank_distancePopWindow = new SpinerPopWindow(getActivity());
		rank_distancePopWindow.refreshData(rank_distanceList, 0);
		rank_distancePopWindow.setRankItemListener(this);

		rank_moneyPopWindow = new SpinerPopWindow(getActivity());
		rank_moneyPopWindow.refreshData(rank_moneyList, 0);
		rank_moneyPopWindow.setRankItemListener(this);

		rank_gloryPopWindow = new SpinerPopWindow(getActivity());
		rank_gloryPopWindow.refreshData(rank_gloryList, 0);
		rank_gloryPopWindow.setRankItemListener(this);

		getOrdersList = OrdersOperated.getInstance().getGetOrdersList();
		mListView = (GetterGetOrdersListView) view
				.findViewById(R.id.getter_get_orders_list);
		mAdapter = new GetterGetOrdersAdapter(getActivity(), getOrdersList,
				mListView.getRightViewWidth());
		mAdapter.setOnItemClickListener(new GetterGetOrdersAdapter.onItemClickListener() {

			@Override
			public void onItemClick() {
				Intent intent = new Intent();
				intent.setClass(getActivity(), GetterReadOrderActivity.class);
				GetOrdersFragment.this.startActivity(intent);
			}
		});

		mAdapter.setOnClickListener(new GetterGetOrdersAdapter.onAvatarClickListener() {

			@Override
			public void onAvatarClick() {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getActivity(), AvatarActivity.class);
				GetOrdersFragment.this.startActivity(intent);
			}
		});
		mListView.setAdapter(mAdapter);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.rank_time_layout:
			rankType = 1;
			showTimeSpinWindow();
			break;
		case R.id.rank_distance_layout:
			rankType = 2;
			showDistanceSpinWindow();
			break;
		case R.id.rank_money_layout:
			rankType = 3;
			showMoneySpinWindow();
			break;

		case R.id.rank_glory_layout:
			rankType = 4;
			showGlorySpinWindow();
			break;
		}
	}

	private void setTime(int pos) {
		if (pos == 0) {
			timeTView.setText("");
			timeTView.setHint("按时间");
		} else if (pos > 0 && pos <= rank_timeList.size()) {
			String value = rank_timeList.get(pos);
			timeTView.setText(value);
		}
		distanceTView.setText("");
		distanceTView.setHint("按距离");
		moneyTView.setText("");
		moneyTView.setHint("按金额");
		gloryTView.setText("");
		gloryTView.setHint("按荣誉");
	}

	private void setDistance(int pos) {
		if (pos == 0) {
			distanceTView.setText("");
			distanceTView.setHint("按距离");
		} else if (pos >= 0 && pos <= rank_distanceList.size()) {
			String value = rank_distanceList.get(pos);
			distanceTView.setText(value);
		}
		timeTView.setText("");
		timeTView.setHint("按时间");
		moneyTView.setText("");
		moneyTView.setHint("按金额");
		gloryTView.setText("");
		gloryTView.setHint("按荣誉");
	}

	private void setMoney(int pos) {
		if (pos == 0) {
			moneyTView.setText("");
			moneyTView.setHint("按金额");
		} else if (pos >= 0 && pos <= rank_moneyList.size()) {
			String value = rank_moneyList.get(pos);
			moneyTView.setText(value);
		}
		timeTView.setText("");
		timeTView.setHint("按时间");
		distanceTView.setText("");
		distanceTView.setHint("按距离");
		gloryTView.setText("");
		gloryTView.setHint("按荣誉");
	}

	private void setGlory(int pos) {
		if (pos == 0) {
			gloryTView.setText("");
			gloryTView.setHint("按荣誉");
		} else if (pos >= 0 && pos <= rank_gloryList.size()) {
			String value = rank_gloryList.get(pos);
			gloryTView.setText(value);
		}
		timeTView.setText("");
		timeTView.setHint("按时间");
		distanceTView.setText("");
		distanceTView.setHint("按距离");
		moneyTView.setText("");
		moneyTView.setHint("按金额");
	}

	private void showTimeSpinWindow() {
		rank_timePopWindow.setWidth(timeTView.getWidth() * 3);
		rank_timePopWindow.showAsDropDown(timeTView);
	}

	private void showDistanceSpinWindow() {
		rank_distancePopWindow.setWidth(distanceTView.getWidth() * 3);
		rank_distancePopWindow.showAsDropDown(distanceTView);
	}

	private void showMoneySpinWindow() {
		rank_moneyPopWindow.setWidth(moneyTView.getWidth() * 3);
		rank_moneyPopWindow.showAsDropDown(moneyTView);
	}

	private void showGlorySpinWindow() {
		rank_gloryPopWindow.setWidth(gloryTView.getWidth() * 3);
		rank_gloryPopWindow.showAsDropDown(gloryTView);
	}

	@Override
	public void onItemClick(int pos) {
		if (rankType == 1) {
			setTime(pos);
			rankType = 0;
		}
		if (rankType == 2) {
			setDistance(pos);
			rankType = 0;
		}
		if (rankType == 3) {
			setMoney(pos);
			rankType = 0;
		}
		if (rankType == 4) {
			setGlory(pos);
			rankType = 0;
		}
	}
}
