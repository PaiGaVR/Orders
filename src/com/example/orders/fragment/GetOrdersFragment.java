package com.example.orders.fragment;

import java.util.List;

import com.example.orders.R;
import com.example.orders.avatar.AvatarActivity;
import com.example.orders.dataoperated.OrdersOperated;
import com.example.orders.entity.Orders;
import com.example.orders.get.GetterGetOrdersAdapter;
import com.example.orders.get.GetterGetOrdersListView;
import com.example.orders.get.GetterReadOrderActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;

public class GetOrdersFragment extends Fragment {

	private List<Orders> getOrdersList;
	private GetterGetOrdersListView mListView;
	private GetterGetOrdersAdapter mAdapter = null;
	private ArrayAdapter<String> adapter;
	private Spinner rankTime;
	private Spinner rankDistance;
	private Spinner rankMoney;
	private Spinner rankGlory;

	public enum rank_time {
		从以前到现在, 从现在到以前
	}

	public enum rank_distance {
		从远到近, 从近到远
	}

	public enum rank_money {
		从少到多, 从多到少
	}

	public enum rank_glory {
		从低到高, 从高到低
	}

	private static final String RTime[] = { "从以前到现在", "从现在到以前" };
	private static final String RDistance[] = { "从远到近", "从近到远" };
	private static final String RMoney[] = { "从少到多", "从多到少" };
	private static final String RGlory[] = { "从低到高", "从高到低" };

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_get_orders, container,
				false);

		rankTime = (Spinner) view.findViewById(R.id.get_rank_time);
		rankDistance = (Spinner) view.findViewById(R.id.get_rank_distance);
		rankMoney = (Spinner) view.findViewById(R.id.get_rank_money);
		rankGlory = (Spinner) view.findViewById(R.id.get_rank_glory);

		initView(view);
		return view;
	}

	/**
	 * 初始化界面
	 */
	private void initView(View view) {

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
}
