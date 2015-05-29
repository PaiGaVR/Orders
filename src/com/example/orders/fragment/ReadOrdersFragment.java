package com.example.orders.fragment;

import java.util.List;

import com.example.orders.R;
import com.example.orders.avatar.AvatarActivity;
import com.example.orders.dataoperated.OrdersOperated;
import com.example.orders.entity.Orders;
import com.example.orders.read.ReadOrderdAdapter;
import com.example.orders.read.ReadOrdersListView;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

public class ReadOrdersFragment extends Fragment {

	private List<Orders> orders = null;
	private ReadOrdersListView mListView;
	private boolean isOver = false;

	private RadioButton read_is_going;
	private RadioButton read_is_over;
	
	ReadOrderdAdapter mAdapter = null;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.activity_read_orders, container, false);
		read_is_going = (RadioButton) view.findViewById(R.id.read_is_going);
		read_is_over = (RadioButton) view.findViewById(R.id.read_is_over);
		read_is_going.setOnClickListener(new IsGoingListener());
		read_is_over.setOnClickListener(new IsOverListener());
		updateData(view);
		return view;
	}

	class IsGoingListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			isOver = false;
			mAdapter.notifyDataSetChanged();
		}
	}

	class IsOverListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			isOver = true;
			mAdapter.notifyDataSetChanged();
		}
	}
	
	private void updateData(View view){
		if (!isOver){
			orders = OrdersOperated.getInstance().getPushingOrders();
		}else{
			orders = OrdersOperated.getInstance().getOverOrders();
		}
		
		if (orders.size() == 0)
			return;
		
		if (mAdapter == null){
			initView(view);
		} else {
			mAdapter.Update(orders);
		}
	}
	
	/**
	 * 初始化界面
	 */
	private void initView(View view) {
		mListView = (ReadOrdersListView) view.findViewById(R.id.read_going_or_over_orders_list);
		mAdapter = new ReadOrderdAdapter(getActivity(), orders,
				mListView.getRightViewWidth());
		mAdapter.setOnItemClickListener(new ReadOrderdAdapter.onItemClickListener() {

			@Override
			public void onItemClick() {

			}
		});

		mAdapter.setOnClickListener(new ReadOrderdAdapter.onAvatarClickListener() {

			@Override
			public void onAvatarClick() {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getActivity(), AvatarActivity.class);
				ReadOrdersFragment.this.startActivity(intent);
			}
		});
		mListView.setAdapter(mAdapter);
	}
}
