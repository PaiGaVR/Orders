package com.example.orders.avatar;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.orders.R;

public class AvatarAdapter extends BaseAdapter {
	/**
	 * 上下文对象
	 */
	private Context mContext = null;
	private List<AvatarMessage> data;

	private int mRightWidth = 0;

	/**
	 * @param mainActivity
	 */
	public AvatarAdapter(Context ctx, List<AvatarMessage> data, int rightWidth) {
		mContext = ctx;
		this.data = data;
		mRightWidth = rightWidth;
	}

	@Override
	public int getCount() {
		return 100;
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
					R.layout.avatar_list_item, parent, false);
			holder = new ViewHolder();
			holder.avatar_item_left = (RelativeLayout) convertView
					.findViewById(R.id.avatar_item_left);

			holder.avatar_iv_icon = (ImageView) convertView
					.findViewById(R.id.avatar_iv_icon);
			holder.avatar_tv_name = (TextView) convertView
					.findViewById(R.id.avatar_tv_name);
			holder.avatar_tv_msg = (TextView) convertView
					.findViewById(R.id.avatar_tv_msg);

			convertView.setTag(holder);
		} else {// 有直接获得ViewHolder
			holder = (ViewHolder) convertView.getTag();
		}

		LinearLayout.LayoutParams lp1 = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		holder.avatar_item_left.setLayoutParams(lp1);
		new LayoutParams(mRightWidth, LayoutParams.MATCH_PARENT);

		AvatarMessage msg = data.get(position);

		holder.avatar_tv_name.setText(msg.getName());
		holder.avatar_tv_msg.setText(msg.getMsg());

		holder.avatar_iv_icon.setImageResource(msg.getIcon_id());

		return convertView;
	}

	static class ViewHolder {
		RelativeLayout avatar_item_left;

		TextView avatar_tv_name;
		TextView avatar_tv_msg;
		ImageView avatar_iv_icon;

	}
}
