package com.example.orders.setting;

import com.example.orders.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PersonalizedSignatureActivity extends Activity {

	private Button setting_gexingqianming_submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting_personalized_signature);

		setting_gexingqianming_submit = (Button) findViewById(R.id.setting_gexingqianming_submit);
		setting_gexingqianming_submit
				.setOnClickListener(new GeXingQianMingSubmitListener());
	}

	class GeXingQianMingSubmitListener implements OnClickListener {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(PersonalizedSignatureActivity.this,
					InformationActivity.class);
			PersonalizedSignatureActivity.this.startActivity(intent);
			PersonalizedSignatureActivity.this.finish();
		}
	}
}
