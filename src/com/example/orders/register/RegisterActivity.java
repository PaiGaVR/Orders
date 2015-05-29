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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	private static final String places[] = { "11", "22", "33", "44", "55",
			"66", "77", "88" };
	private boolean isNotified = false;
	private int sexFlag = 0;
	private boolean isChecked = false;
	private int plcFlag = 0;

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
		Spinner from = (Spinner) findViewById(R.id.register_place);
		final EditText mail = (EditText) findViewById(R.id.register_mail);
		final TextView register_read_clause = (TextView) findViewById(R.id.register_clause);
		CheckBox check = (CheckBox) findViewById(R.id.register_check);
		Button register = (Button) findViewById(R.id.register_queren);
		Button cancel = (Button) findViewById(R.id.register_quxiao);
		// 给Spinner设置适配器
		ArrayAdapter<?> adapter = new ArrayAdapter<Object>(this,
				android.R.layout.simple_spinner_item, places);
		// 设置下拉菜单样式
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		from.setAdapter(adapter);
		// 事件监听
		check.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean flag) {
				// TODO Auto-generated method stub
				isChecked = flag;
			}
		});

		register_read_clause.setOnClickListener(ReadClauselistener);

		sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int flag) {
				// TODO Auto-generated method stub
				sexFlag = flag;
			}
		});
		from.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int flag, long arg3) {
				plcFlag = flag;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

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
				String strMail = mail.getText().toString();
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
				// 发送数据到另一个Activity
				Bundle bundle = new Bundle();
				bundle.putString("username", strUser);
				bundle.putString("mail", strMail);
				bundle.putString("from", places[plcFlag]);
				// bundle.putString("from", "中国");
				bundle.putBoolean("notify", isNotified);
				bundle.putBoolean("check", isChecked);
				bundle.putInt("sex", sexFlag);
				Intent intent = new Intent(RegisterActivity.this,
						LoginActivity.class);
				intent.putExtra("info", bundle);
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	private View.OnClickListener ReadClauselistener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(RegisterActivity.this, ClauseActivity.class);
			RegisterActivity.this.startActivity(intent);
		}
	};
}
