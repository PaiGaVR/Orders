package com.example.orders.push;

import java.util.List;

import android.content.Context;
import android.content.Intent;
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
import com.example.orders.adapter.SwipeAdapter.onRightItemClickListener;
import com.example.orders.avatar.AvatarActivity;

public class PusherGetGetterAdapter extends BaseAdapter {
	/**
	 * 上下文对象
	 */
	private Context mContext = null;
	private List<PusherGetGetter> data;

	private int mRightWidth = 0;

	/**
	 * @param mainActivity
	 */
	public PusherGetGetterAdapter(Context ctx, List<PusherGetGetter> data,
			int rightWidth) {
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
					R.layout.pusher_get_getter_list, parent, false);
			holder = new ViewHolder();
			holder.pusher_get_getter_item_left = (RelativeLayout) convertView
					.findViewById(R.id.pusher_get_getter_item_left);

			holder.pusher_get_getter_iv_icon = (ImageView) convertView
					.findViewById(R.id.pusher_get_getter_iv_icon);
			holder.pusher_get_getter_tv_name = (TextView) convertView
					.findViewById(R.id.pusher_get_getter_name);
			holder.pusher_get_getter_tv_getNum = (TextView) convertView
					.findViewById(R.id.pusher_get_getter_getNum);
			holder.pusher_get_getter_tv_pushNum = (TextView) convertView
					.findViewById(R.id.pusher_get_getter_pushNum);
			holder.pusher_get_getter_tv_gloryNum = (TextView) convertView
					.findViewById(R.id.pusher_get_getter_gloryNum);

			convertView.setTag(holder);
		} else {// 有直接获得ViewHolder
			holder = (ViewHolder) convertView.getTag();
		}

		LinearLayout.LayoutParams lp1 = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		holder.pusher_get_getter_item_left.setLayoutParams(lp1);
		new LayoutParams(mRightWidth, LayoutParams.MATCH_PARENT);

		PusherGetGetter msg = data.get(position);

		holder.pusher_get_getter_tv_name.setText(msg.getName());
		holder.pusher_get_getter_tv_getNum.setText(msg.getGetNum());
		holder.pusher_get_getter_tv_pushNum.setText(msg.getPushNum());
		holder.pusher_get_getter_tv_gloryNum.setText(msg.getGloryNum());

		holder.pusher_get_getter_iv_icon.setImageResource(msg.getIcon_id());

		holder.pusher_get_getter_item_left
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (mListener != null) {
							mListener.onItemClick();
						}
					}
				});

		holder.pusher_get_getter_iv_icon
				.setOnClickListener(new OnClickListener() {

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
		RelativeLayout pusher_get_getter_item_left;

		TextView pusher_get_getter_tv_name;
		TextView pusher_get_getter_tv_getNum;
		TextView pusher_get_getter_tv_pushNum;
		TextView pusher_get_getter_tv_gloryNum;
		ImageView pusher_get_getter_iv_icon;
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
