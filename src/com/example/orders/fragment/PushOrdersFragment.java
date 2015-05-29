package com.example.orders.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.orders.R;
import com.example.orders.activity.MainActivity;
import com.example.orders.adapter.SwipeAdapter;
import com.example.orders.dataoperated.OrdersOperated;
import com.example.orders.entity.Orders;
import com.example.orders.push.PusherReadGetterActivity;
import com.example.orders.widgets.PushOrdersListView;

public class PushOrdersFragment extends Fragment {

	private List<Orders> pushOrdersList = null;
	private PushOrdersListView mListView;
	
	private SwipeAdapter mAdapter;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.activity_push_orders, container, false);
		initView(view);
		
		return view;
	}
	
	private void initView(View view){
		pushOrdersList = OrdersOperated.getInstance().getPushOrdersList();
		mListView = (PushOrdersListView) view.findViewById(R.id.push_orders_list);
		System.out.println(((MainActivity)getActivity()).getViewPager());
		mListView.setMyViewPager(((MainActivity)getActivity()).getViewPager());
		mAdapter = new SwipeAdapter(getActivity().getBaseContext(), pushOrdersList,
				mListView.getRightViewWidth());

		mAdapter.setOnRightItemClickListener(new SwipeAdapter.onRightItemClickListener() {

			@Override
			public void onRightItemClick(View v, int position) {
				Toast.makeText(getActivity(),
						"删除第  " + (position + 1) + " 对话记录", Toast.LENGTH_SHORT)
						.show();
			}
		});
		
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(getActivity(),
						PusherReadGetterActivity.class);
				intent.putExtra("index", position);
				PushOrdersFragment.this.startActivity(intent);
			}
		});
	}
	
	public void addOrder(Intent data) {
		Orders order = new Orders();
		order.setTheme(data.getStringExtra("theme"));
		order.setContent(data.getStringExtra("content"));
		order.setPushMoney(data.getDoubleExtra("pushMoney", 0.0));
		order.setAimArea(data.getStringExtra("aimArea"));
		order.setAimTime(data.getStringExtra("aimTime"));
		
		// 写Orders操作
		pushOrdersList = OrdersOperated.getInstance().writeOrder(order);
		mAdapter.notifyDataSetChanged();
	}
}
