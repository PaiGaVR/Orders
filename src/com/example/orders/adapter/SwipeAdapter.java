package com.example.orders.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.orders.R;
import com.example.orders.entity.Orders;

public class SwipeAdapter extends BaseAdapter {
	/**
	 * 上下文对象
	 */
	private Context mContext = null;
	private List<Orders> data;

	private int mRightWidth = 0;

	/**
	 * @param mainActivity
	 */
	public SwipeAdapter(Context ctx, List<Orders> data, int rightWidth) {
		mContext = ctx;
		this.data = data;
		mRightWidth = rightWidth;
	}

	@Override
	public int getCount() {
		return (data == null) ? 0 : data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.push_orders_list_item, parent, false);
			holder = new ViewHolder();
			holder.item_left = (RelativeLayout) convertView
					.findViewById(R.id.item_left);
			holder.item_right = (RelativeLayout) convertView
					.findViewById(R.id.item_right);

			holder.aim_time = (TextView) convertView
					.findViewById(R.id.aim_time);
			holder.aim_area = (TextView) convertView
					.findViewById(R.id.aim_area);
			holder.content = (TextView) convertView.findViewById(R.id.content);
			
			holder.num_icon = (ImageView) convertView
					.findViewById(R.id.num_icon);
			holder.type_icon = (ImageView) convertView
					.findViewById(R.id.type_icon);
			
			holder.item_right_txt = (TextView) convertView
					.findViewById(R.id.item_right_txt);
			convertView.setTag(holder);
		} else {// 有直接获得ViewHolder
			holder = (ViewHolder) convertView.getTag();
		}

		LinearLayout.LayoutParams lp1 = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		holder.item_left.setLayoutParams(lp1);
		LinearLayout.LayoutParams lp2 = new LayoutParams(mRightWidth,
				LayoutParams.MATCH_PARENT);
		holder.item_right.setLayoutParams(lp2);

		Orders order = data.get(position);

		holder.aim_time.setText("." + order.getAimTime().substring(2));
		holder.aim_area.setText(order.getAimArea());
		holder.content.setText(order.getContent());
		// TODO 获取新接单数和类型

		holder.item_right.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mListener != null) {
					mListener.onRightItemClick(v, position);
				}
			}
		});
		return convertView;
	}

	static class ViewHolder {
		RelativeLayout item_left;
		RelativeLayout item_right;

		TextView aim_time;
		TextView aim_area;
		TextView content;
		ImageView type_icon;
		ImageView num_icon;

		TextView item_right_txt;
	}

	/**
	 * 单击事件监听器
	 */
	private onRightItemClickListener mListener = null;

	public void setOnRightItemClickListener(onRightItemClickListener listener) {
		mListener = listener;
	}

	public interface onRightItemClickListener {
		void onRightItemClick(View v, int position);
	}
}
