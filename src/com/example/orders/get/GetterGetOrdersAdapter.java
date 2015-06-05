package com.example.orders.get;

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

public class GetterGetOrdersAdapter extends BaseAdapter {
	/**
	 * 上下文对象
	 */
	private Context mContext = null;
	private List<Orders> data;

	private int mRightWidth = 0;

	/**
	 * @param mainActivity
	 */
	public GetterGetOrdersAdapter(Context ctx, List<Orders> data, int rightWidth) {
		mContext = ctx;
		this.data = data;
		mRightWidth = rightWidth;
	}

	public void UpdateData(List<Orders> data) {
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
					R.layout.getter_get_orders_list, parent, false);
			holder = new ViewHolder();
			holder.getter_get_order__item_left = (RelativeLayout) convertView
					.findViewById(R.id.getter_get_order_item_left);

			holder.getter_get_order_icon = (ImageView) convertView
					.findViewById(R.id.getter_get_order_icon);
			holder.getter_get_order_name_info = (TextView) convertView
					.findViewById(R.id.getter_get_order_name_info);
			holder.getter_get_order_time_info = (TextView) convertView
					.findViewById(R.id.getter_get_order_time_info);
			holder.getter_get_order_place_info = (TextView) convertView
					.findViewById(R.id.getter_get_order_place_info);
			holder.getter_get_order_money_info = (TextView) convertView
					.findViewById(R.id.getter_get_order_money_info);
			holder.getter_get_order_type_info = (TextView) convertView
					.findViewById(R.id.getter_get_order_type_info);

			convertView.setTag(holder);
		} else {// 有直接获得ViewHolder
			holder = (ViewHolder) convertView.getTag();
		}

		LinearLayout.LayoutParams lp1 = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		holder.getter_get_order__item_left.setLayoutParams(lp1);
		new LayoutParams(mRightWidth, LayoutParams.MATCH_PARENT);

		Orders msg = data.get(position);

		holder.getter_get_order_name_info.setText(msg.getpName());
		holder.getter_get_order_time_info.setText(msg.getAimTime());
		holder.getter_get_order_place_info.setText(msg.getAimArea());
		holder.getter_get_order_money_info.setText(Double.toString(msg
				.getPushMoney()));
		holder.getter_get_order_type_info.setText(msg.getType());
		// holder.getter_get_order_icon.setImageResource(msg.getIcon_id());

		holder.getter_get_order__item_left
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (mListener != null) {
							mListener.onItemClick();
						}
					}
				});

		holder.getter_get_order_icon.setOnClickListener(new OnClickListener() {

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
		RelativeLayout getter_get_order__item_left;

		TextView getter_get_order_name_info;
		TextView getter_get_order_time_info;
		TextView getter_get_order_place_info;
		TextView getter_get_order_money_info;
		TextView getter_get_order_type_info;
		ImageView getter_get_order_icon;
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
