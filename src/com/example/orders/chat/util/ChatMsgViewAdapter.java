package com.example.orders.chat.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import com.example.orders.R;

public class ChatMsgViewAdapter extends BaseAdapter {

	public static interface IMsgViewType {

		int IMVT_COM_MSG = 0;

		int IMVT_TO_MSG = 1;

		int IMVT_COM_MSG_IMP = 2;

		int IMVT_TO_MSG_IMP = 3;
	}

	private List<ChatMsgEntity> data;
	private LayoutInflater mInflater;

	public ChatMsgViewAdapter(Context context, List<ChatMsgEntity> data) {
		this.data = data;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return (data == null) ? 0 : data.size();
	}

	public Object getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		ChatMsgEntity entity = data.get(position);

		if (entity.getMsgType()) {
			if (entity.getMsgTypeImport()) {
				return IMsgViewType.IMVT_COM_MSG_IMP;
			} else {
				return IMsgViewType.IMVT_COM_MSG;
			}
		} else {
			if (entity.getMsgTypeImport()) {
				return IMsgViewType.IMVT_TO_MSG_IMP;
			} else {
				return IMsgViewType.IMVT_TO_MSG;
			}
		}
	}

	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ChatMsgEntity entity = data.get(position);
		boolean isComMsg = entity.getMsgType();
		boolean isImport = entity.getMsgTypeImport();

		ViewHolder viewHolder = null;
		if (convertView == null) {
			if (isComMsg) {
				if (isImport) {
					convertView = mInflater.inflate(
							R.layout.chatting_item_msg_text_left_importance,
							null);
				} else {
					convertView = mInflater.inflate(
							R.layout.chatting_item_msg_text_left, null);
				}
			} else {

				if (isImport) {
					convertView = mInflater.inflate(
							R.layout.chatting_item_msg_text_right_importance,
							null);
				} else {
					convertView = mInflater.inflate(
							R.layout.chatting_item_msg_text_right, null);
				}
			}

			if (!isImport) {
				viewHolder = new ViewHolder();
				viewHolder.tvSendTime = (TextView) convertView
						.findViewById(R.id.tv_sendtime);
				viewHolder.tvUserName = (TextView) convertView
						.findViewById(R.id.tv_username);
				viewHolder.tvContent = (TextView) convertView
						.findViewById(R.id.tv_chatcontent);
				viewHolder.isComMsg = isComMsg;
				viewHolder.isImport = isImport;
			}else{
				viewHolder = new ViewHolder();
				viewHolder.tvSendTime = (TextView) convertView
						.findViewById(R.id.tv_sendtime);
				viewHolder.tvUserName = (TextView) convertView
						.findViewById(R.id.tv_username);
				viewHolder.tvContent = (TextView) convertView
						.findViewById(R.id.tv_chatcontent_imp);
				viewHolder.isComMsg = isComMsg;
				viewHolder.isImport = isImport;
			}

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.tvSendTime.setText(entity.getDate());
		viewHolder.tvUserName.setText(entity.getName());
		viewHolder.tvContent.setText(entity.getText());
		return convertView;
	}

	static class ViewHolder {
		public TextView tvSendTime;
		public TextView tvUserName;
		public TextView tvContent;
		public TextView tvContent_imp;
		public boolean isComMsg = true;
		public boolean isImport = false;
	}

}
