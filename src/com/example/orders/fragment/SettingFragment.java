package com.example.orders.fragment;

import com.example.orders.R;
import com.example.orders.setting.AboutActivity;
import com.example.orders.setting.HelpActivity;
import com.example.orders.setting.InformationActivity;
import com.example.orders.setting.NotificationActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.content.Intent;

public class SettingFragment extends Fragment {
	public static SettingFragment instance = null;
	private RelativeLayout gerenxinxi;
//	private Button dialog_exit;
	private RelativeLayout guanyu;
	private RelativeLayout xitongtongzhi;
	private RelativeLayout bangzhuyufankui;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_setting, container,
				false);

		gerenxinxi = (RelativeLayout) view.findViewById(R.id.gerenxinxi);
		gerenxinxi.setOnClickListener(new GeRenXinXiListener());

		// dialog_exit = (Button) view.findViewById(R.id.dialog_exit);
		// dialog_exit.setOnClickListener(new MyExitButtonListener());

		// 帮助反馈
		bangzhuyufankui = (RelativeLayout) view
				.findViewById(R.id.bangzhuyufankui);
		bangzhuyufankui.setOnClickListener(new BangZhuYuFanKuiListener());

		// 通知
		xitongtongzhi = (RelativeLayout) view.findViewById(R.id.xitongtongzhi);
		xitongtongzhi.setOnClickListener(new MyXiTongTongZhiListener());

		// 关于
		guanyu = (RelativeLayout) view.findViewById(R.id.guanyu);
		guanyu.setOnClickListener(new MyGuanYuListener());

		return view;
	}

	class GeRenXinXiListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(getActivity(), InformationActivity.class);
			getActivity().startActivity(intent);
		}
	}

	class BangZhuYuFanKuiListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(getActivity(), HelpActivity.class);
			getActivity().startActivity(intent);
		}
	}

	// class MyExitButtonListener implements OnClickListener {
	// public void onClick(View v) {
	// // TODO Auto-generated method stub
	// Intent intent = new Intent();
	// intent.setClass(getActivity(), ExitFromSettingsActivity.class);
	// getActivity().startActivity(intent);
	// }
	// }

	class MyXiTongTongZhiListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(getActivity(), NotificationActivity.class);
			getActivity().startActivity(intent);
		}
	}

	class MyGuanYuListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(getActivity(), AboutActivity.class);
			getActivity().startActivity(intent);
		}
	}
}
