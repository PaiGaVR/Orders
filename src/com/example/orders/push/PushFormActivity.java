package com.example.orders.push;

import java.util.Calendar;

import com.example.orders.R;
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

	private EditText showDate = null;
	private Button pickDate = null;
	private static final int DATE_DIALOG_ID = 1;
	private static final int SHOW_DATAPICK = 0;
	private int mYear;
	private int mMonth;
	private int mDay;
	private TextView text = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_push_form);

		//时间选择
		showDate = (EditText) findViewById(R.id.showDate);
		pickDate = (Button) findViewById(R.id.but_showDate);
		pickDate.setOnClickListener(new DateButtonOnClickListener());
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		setDateTime();

		//地点选择
		text = (TextView) findViewById(R.id.addressinfo);
		Button placeButton = (Button) findViewById(R.id.placebutton);
		final GetAddressUtil location = new GetAddressUtil(this);

		placeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(PushFormActivity.this,
						GetAddressInfoActivity.class), 10000);
			}
		});
	}

	//地点显示
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (null != data && resultCode == Activity.RESULT_OK) {
			text.setText(data.getStringExtra("province") + ","
					+ data.getStringExtra("city"));
		}
	}

	private void setDateTime() {
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		updateDisplay();
	}

	/**
	 * 更新日期
	 */

	private void updateDisplay() {
		showDate.setText(new StringBuilder().append(mYear).append(
		(mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1)).append(
		(mDay < 10) ? "0" + mDay : mDay));
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
			Message msg = new Message();
			if (pickDate.equals((Button) v)) {
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
