package com.example.orders.read;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.orders.R;
import com.example.orders.entity.Orders;

public class ReadOrderdAdapter extends BaseAdapter {
	/**
	 * 上下文对象
	 */
	private Context mContext = null;
	private List<Orders> data;

	private int mRightWidth = 0;

	/**
	 * @param mainActivity
	 */
	public ReadOrderdAdapter(Context ctx, List<Orders> data, int rightWidth) {
		mContext = ctx;
		this.data = data;
		mRightWidth = rightWidth;
	}
	
	public void Update(List<Orders> data){
		this.data = data;
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
					R.layout.read_orders_list, parent, false);
			holder = new ViewHolder();
			holder.read_orders_item_left = (RelativeLayout) convertView
					.findViewById(R.id.read_orders_item_left);

			holder.read_orders_icon = (ImageView) convertView
					.findViewById(R.id.read_orders_icon);
			holder.read_orders_type_info = (TextView) convertView
					.findViewById(R.id.read_orders_type_info);
			holder.read_orders_name_info = (TextView) convertView
					.findViewById(R.id.read_orders_name_info);
			holder.read_orders_time_info = (TextView) convertView
					.findViewById(R.id.read_orders_time_info);
			holder.read_orders_money_info = (TextView) convertView
					.findViewById(R.id.read_orders_money_info);

			convertView.setTag(holder);
		} else {// 有直接获得ViewHolder
			holder = (ViewHolder) convertView.getTag();
		}

		LinearLayout.LayoutParams lp1 = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		holder.read_orders_item_left.setLayoutParams(lp1);
		new LayoutParams(mRightWidth, LayoutParams.MATCH_PARENT);

		Orders msg = data.get(position);

		holder.read_orders_type_info.setText(msg.getType());
		holder.read_orders_name_info.setText(msg.getpName());
		holder.read_orders_time_info.setText(msg.getAimTime());
		holder.read_orders_money_info.setText(Double.toString(msg.getPushMoney()));
		//holder.read_orders_icon.setImageResource(msg.getIcon_id());

		holder.read_orders_item_left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mListener != null) {
					mListener.onItemClick();
				}
			}
		});

		holder.read_orders_icon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (avatarListener != null) {
					avatarListener.onAvatarClick();
				}
			}
		});
		return convertView;
	}

	static class ViewHolder {
		RelativeLayout read_orders_item_left;

		TextView read_orders_type_info;
		TextView read_orders_name_info;
		TextView read_orders_time_info;
		TextView read_orders_money_info;
		ImageView read_orders_icon;
	}

	/**
	 * 单击事件监听器
	 */
	private onItemClickListener mListener = null;

	public void setOnItemClickListener(onItemClickListener listener) {
		mListener = listener;
	}

	public interface onItemClickListener {
		void onItemClick();
	}

	private onAvatarClickListener avatarListener = null;

	public void setOnClickListener(onAvatarClickListener listener) {
		avatarListener = listener;
	}

	public interface onAvatarClickListener {
		void onAvatarClick();
	}

}
