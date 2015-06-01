package com.example.orders.register;

import com.example.orders.R;
import com.example.orders.login.LoginActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioGroup;

public class RegisterActivity extends Activity {
	private boolean isChecked = false;
	private EditText place;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		// 设置标题
		setTitle("注册成功");
		// 获取控件
		final EditText username = (EditText) findViewById(R.id.register_username);
		final EditText pwd = (EditText) findViewById(R.id.register_pwd);
		final EditText pwdrp = (EditText) findViewById(R.id.register_pwdrp);
		final EditText sfID = (EditText) findViewById(R.id.register_shenfenID);
		RadioGroup sex = (RadioGroup) findViewById(R.id.register_sex);
		place = (EditText) findViewById(R.id.register_place_info);
		final EditText phoNum = (EditText) findViewById(R.id.register_phonrNum);
		CheckBox check = (CheckBox) findViewById(R.id.register_check);
		Button register = (Button) findViewById(R.id.register_queren);
		Button cancel = (Button) findViewById(R.id.register_quxiao);
		// 事件监听
		check.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean flag) {
				// TODO Auto-generated method stub
				isChecked = flag;
			}
		});

		check.setOnClickListener(ReadClauselistener);

		sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int flag) {
			}
		});
		// final GetAddressUtil location = new GetAddressUtil(this);
		place.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(RegisterActivity.this,SelectCitiesDialogActivity.class);
				startActivityForResult(intent, 1001);
			}
		});
		register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String strUser = username.getText().toString();
				String strPwd = pwd.getText().toString();
				String strPwdrp = pwdrp.getText().toString();
				String strSfID = sfID.getText().toString();
				String phoneNum = phoNum.getText().toString();
				if (strUser.equals("")) {
					// 弹出对话框
					new AlertDialog.Builder(RegisterActivity.this)
							.setIcon(android.R.drawable.ic_dialog_alert)
							.setTitle("警告").setMessage("请输入用户名")
							.setPositiveButton("确定", null).show();
					return;
				}
				if (!strPwd.equals(strPwdrp)) {
					// 弹出对话框
					new AlertDialog.Builder(RegisterActivity.this)
							.setIcon(android.R.drawable.ic_dialog_alert)
							.setTitle("警告").setMessage("两次输入的密码不相同")
							.setPositiveButton("确定", null).show();
					return;
				}
				if (!isChecked) {
					// 弹出对话框
					new AlertDialog.Builder(RegisterActivity.this)
							.setIcon(android.R.drawable.ic_dialog_alert)
							.setTitle("警告").setMessage("请勾选同意条款")
							.setPositiveButton("确定", null).show();
					return;
				}
				if (strSfID.length() != 18) {
					new AlertDialog.Builder(RegisterActivity.this)
							.setIcon(android.R.drawable.ic_dialog_alert)
							.setTitle("警告").setMessage("身份证号输入有误")
							.setPositiveButton("确定", null).show();
					return;

				}
				if (phoneNum.length() != 11) {
					new AlertDialog.Builder(RegisterActivity.this)
							.setIcon(android.R.drawable.ic_dialog_alert)
							.setTitle("警告").setMessage("电话号码输入有误")
							.setPositiveButton("确定", null).show();
					return;

				}

				// 发送数据到另一个Activity
				Bundle bundle = new Bundle();
				bundle.putString("username", strUser);
				bundle.putString("password", strPwd);
				bundle.putBoolean("isRegister", true);
				Intent intent = new Intent(RegisterActivity.this,
						LoginActivity.class);
				intent.putExtras(bundle);
				// 启动这个Activity
				RegisterActivity.this.startActivity(intent);
				// 结束本Activity
				RegisterActivity.this.finish();
			}
		});
		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RegisterActivity.this.finish();
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (null != data && resultCode == Activity.RESULT_OK) {
			if(requestCode==1001&&resultCode==1002){
				place.setText(data.getStringExtra("address"));
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	private View.OnClickListener ReadClauselistener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			isChecked = true;
			Intent intent = new Intent();
			intent.setClass(RegisterActivity.this, ClauseActivity.class);
			RegisterActivity.this.startActivity(intent);

		}
	};
}
