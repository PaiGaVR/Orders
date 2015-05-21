package com.example.orders.login;

import com.example.orders.R;
import com.example.orders.register.RegisterActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class WelcomeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
	}
	public void welcome_login(View v) {  
      	Intent intent = new Intent();
		intent.setClass(WelcomeActivity.this,LoginActivity.class);
		startActivity(intent);
		//this.finish();
      }  
    public void welcome_register(View v) {  
      	Intent intent = new Intent();
		intent.setClass(WelcomeActivity.this,RegisterActivity.class);
		startActivity(intent);
		//this.finish();
      }  

}
