package com.example.orders.get;

import com.example.orders.R;
import com.example.orders.avatar.AvatarActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class GetterReadOrderActivity extends Activity {

	private ImageButton pusherAvatar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.getter_read_order);

		pusherAvatar = (ImageButton) findViewById(R.id.getter_read_order_pusher_avatar);
		pusherAvatar.setOnClickListener(new ClickPusherAvatarListener());
	}

	class ClickPusherAvatarListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(GetterReadOrderActivity.this, AvatarActivity.class);
			GetterReadOrderActivity.this.startActivity(intent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.getter_read_order, menu);
		return true;
	}

}
