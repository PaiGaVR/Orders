package com.example.orders.chat;

import com.example.orders.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddMoneyActivity extends Activity {

	private Button queRenAdd;
	private EditText add_money;
	private EditText add_reason;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pusher_add_money);

		queRenAdd = (Button) findViewById(R.id.querenaddButton);
		queRenAdd.setOnClickListener(new QueRenAddListener());

		add_money = (EditText) findViewById(R.id.add_money);
		add_reason = (EditText) findViewById(R.id.add_reason);
	}

	class QueRenAddListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String add_M = add_money.getText().toString();
			String add_R = add_reason.getText().toString();

			if (add_M.equals("")) {
				// 弹出对话框
				new AlertDialog.Builder(AddMoneyActivity.this)
						.setIcon(android.R.drawable.ic_dialog_alert)
						.setTitle("警告").setMessage("请输入金额")
						.setPositiveButton("确定", null).show();
				return;
			}
			if (add_R.equals("")) {
				// 弹出对话框
				new AlertDialog.Builder(AddMoneyActivity.this)
						.setIcon(android.R.drawable.ic_dialog_alert)
						.setTitle("警告").setMessage("请输入原因")
						.setPositiveButton("确定", null).show();
				return;
			}

			/*
			 * Intent intent = new Intent();
			 * intent.setClass(AddMoneyActivity.this, ChatActivity.class);
			 * Bundle mBundle = new Bundle(); mBundle.putString("isRead",
			 * "true");// 压入数据 mBundle.putString("add_M", add_M);
			 * mBundle.putString("add_R", add_R); intent.putExtras(mBundle);
			 * AddMoneyActivity.this.startActivity(intent);
			 * AddMoneyActivity.this.finish();
			 */

			Intent intent = new Intent();
			intent.putExtra("add_M", add_M);
			intent.putExtra("add_R", add_R);
			setResult(Activity.RESULT_OK, intent);
			finish();
		}
	}
}
