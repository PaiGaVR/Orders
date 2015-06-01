package com.example.orders.push;

import java.util.Calendar;

import com.example.orders.R;
import com.example.orders.dataoperated.ResultCode;
import com.example.util.CheckUtil;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class PushFormActivity extends Activity {

	private static final int DATE_DIALOG_ID = 1;
	private static final int SHOW_DATAPICK = 0;
	private int mYear;
	private int mMonth;
	private int mDay;

	private EditText themeEdit = null;
	private EditText contentEdit = null;
	private EditText pushMoneyEdit = null;
	private TextView aimArea = null;
	private EditText aimTime = null;
	private Button addButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_push_form);

		// 主题输入框
		themeEdit = (EditText) findViewById(R.id.theme_edit);

		contentEdit = (EditText) findViewById(R.id.content_edit);

		pushMoneyEdit = (EditText) findViewById(R.id.push_money_edit);

		// 地点选择
		aimArea = (TextView) findViewById(R.id.addressinfo);
		aimArea.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				aimArea.clearFocus();
				startActivityForResult(new Intent(PushFormActivity.this,
						GetAddressInfoActivity.class), 10000);
			}
		});

		// 时间选择
		aimTime = (EditText) findViewById(R.id.showDate);
		aimTime.setOnClickListener(new DateButtonOnClickListener());
		setDateTime();

		addButton = (Button) findViewById(R.id.add);
		addButton.setOnClickListener(new AddButtonListener());
	}

	/**
	 * 提交按钮的点击事件
	 * 
	 * @author GXD
	 * 
	 */
	private class AddButtonListener implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			boolean hasError = false;
			if (!hasError && CheckUtil.isNull(themeEdit.getText().toString())) {
				themeEdit.setHint("主题不能为空");
				themeEdit.setHintTextColor(getResources().getColor(
						R.color.error_hint));
				hasError = true;
			}

			if (!hasError && CheckUtil.isNull(contentEdit.getText().toString())) {
				contentEdit.setHint("内容不能为空");
				contentEdit.setHintTextColor(getResources().getColor(
						R.color.error_hint));
				hasError = true;
			}

			if (!hasError
					&& CheckUtil.isNull(pushMoneyEdit.getText().toString())) {
				pushMoneyEdit.setHint("金额不能为空");
				pushMoneyEdit.setHintTextColor(getResources().getColor(
						R.color.error_hint));
				hasError = true;
			}

			if (!hasError && CheckUtil.isNull(aimArea.getText().toString())) {
				aimArea.setHint("地点不能为空");
				aimArea.setHintTextColor(getResources().getColor(
						R.color.error_hint));
				hasError = true;
			}

			if (!hasError && CheckUtil.isNull(aimTime.getText().toString())) {
				aimTime.setHint("时间不能为空");
				aimTime.setHintTextColor(getResources().getColor(
						R.color.error_hint));
				hasError = true;
			}

			if (!hasError) {
				Intent returnData = new Intent();

				returnData.putExtra("theme", themeEdit.getText().toString());
				returnData
						.putExtra("content", contentEdit.getText().toString());
				returnData.putExtra("pushMoney",
						Double.parseDouble(pushMoneyEdit.getText().toString()));
				returnData.putExtra("aimArea", aimArea.getText().toString());
				returnData.putExtra("aimTime", aimTime.getText().toString());

				setResult(ResultCode.PUSH_ORDERS, returnData);
				finish();
			}
		}
	}

	// 地点显示
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (null != data && resultCode == Activity.RESULT_OK) {

			aimArea.setText(data.getStringExtra("province") + "-"
					+ data.getStringExtra("city"));
		}
	}

	private void setDateTime() {
		Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		updateDisplay();
	}

	/**
	 * 更新日期
	 */

	private void updateDisplay() {
		aimTime.setText(new StringBuilder()
				.append(mYear + "-")
				.append((mMonth + 1) < 10 ? "0" + (mMonth + 1) + "-"
						: (mMonth + 1) + "-")
				.append((mDay < 10) ? "0" + mDay : mDay));
	}

	/**
	 * 日期控件的事件
	 */

	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDisplay();
		}
	};

	/**
	 * 选择日期Button的事件处理
	 */
	class DateButtonOnClickListener implements
			android.view.View.OnClickListener {
		@Override
		public void onClick(View v) {
			aimTime.clearFocus();
			Message msg = new Message();
			if (aimTime.equals((EditText) v)) {
				msg.what = PushFormActivity.SHOW_DATAPICK;
			}
			PushFormActivity.this.saleHandler.sendMessage(msg);
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
					mDay);
		}
		return null;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case DATE_DIALOG_ID:
			((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);
			break;
		}
	}

	/**
	 * 处理日期控件的Handler
	 */

	Handler saleHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case PushFormActivity.SHOW_DATAPICK:
				showDialog(DATE_DIALOG_ID);
				break;
			}
		}
	};
}
