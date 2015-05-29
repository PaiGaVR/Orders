package com.example.order.chat;

import com.example.orders.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AddMoneyActivity extends Activity {

	private Button queRenAdd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pusher_add_money);
		
		queRenAdd = (Button) findViewById(R.id.querenaddButton);
		queRenAdd.setOnClickListener(new QueRenAddListener());
	}

	class QueRenAddListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 
			Intent intent = new Intent();
			intent.setClass(AddMoneyActivity.this, PusherChatActivity.class);
			AddMoneyActivity.this.startActivity(intent);
			AddMoneyActivity.this.finish();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_money, menu);
		return true;
	}

}
