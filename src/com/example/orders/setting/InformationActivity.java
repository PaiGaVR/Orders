package com.example.orders.setting;

import java.io.File;

import com.example.orders.R;
import com.example.orders.push.GetAddressInfoActivity;
import com.example.orders.push.GetAddressUtil;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class InformationActivity extends Activity {

	private String type = "";
	/* 组件 */
	private RelativeLayout switchAvatar;
	private ImageView faceImage;

	private String[] items = new String[] { "选择本地图片", "拍照" };
	/* 头像名称 */
	private static final String IMAGE_FILE_NAME = "faceImage.jpg";

	/* 请求码 */
	private static final int IMAGE_REQUEST_CODE = 0;
	private static final int CAMERA_REQUEST_CODE = 1;
	private static final int RESULT_REQUEST_CODE = 2;
	private TextView placetext = null;
	private TextView sextext = null;
	private TextView gexingqianming = null;
	private TextView nicheng = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setting_information);

		// 头像选择
		switchAvatar = (RelativeLayout) findViewById(R.id.main_tab_setting_information_rl);
		faceImage = (ImageView) findViewById(R.id.main_tab_setting_information_head);
		switchAvatar.setOnClickListener(TXlistener);

		// 地点选择
		placetext = (TextView) findViewById(R.id.setting_addressinfo);
		RelativeLayout placeRelativeLayout = (RelativeLayout) findViewById(R.id.setting_place_information);
		final GetAddressUtil location = new GetAddressUtil(this);
		placeRelativeLayout.setOnClickListener(DQlistener);

		// 性别选择
		sextext = (TextView) findViewById(R.id.setting_sexinfo);
		RelativeLayout sexRelativeLayout = (RelativeLayout) findViewById(R.id.setting_sex_information);
		sexRelativeLayout.setOnClickListener(XBlistener);

		// 个性签名
		gexingqianming = (TextView) findViewById(R.id.setting_gexingqianming);
		RelativeLayout qianmingRelativeLayout = (RelativeLayout) findViewById(R.id.setting_gexingqianming_information);
		gexingqianming.setOnClickListener(QMlistener);
		qianmingRelativeLayout.setOnClickListener(QMlistener);

		nicheng = (TextView) findViewById(R.id.setting_name);
		RelativeLayout nichengRelativeLayout = (RelativeLayout) findViewById(R.id.setting_name_information);
		nicheng.setOnClickListener(NClistener);
		nichengRelativeLayout.setOnClickListener(NClistener);
	}

	private View.OnClickListener XBlistener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					InformationActivity.this);
			builder.setIcon(R.drawable.tab_settings_normal);
			builder.setTitle("请选择性别");
			final String[] sex = { "男", "女", "未知性别" };
			builder.setSingleChoiceItems(sex, 2,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							sextext.setText(sex[which]);
						}
					});
			builder.show();
		}
	};

	private View.OnClickListener DQlistener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			type = "DQ";
			startActivityForResult(new Intent(InformationActivity.this,
					GetAddressInfoActivity.class), 10000);
		}
	};

	private View.OnClickListener TXlistener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			showDialog();
			type = "TX";
		}
	};

	private View.OnClickListener QMlistener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(InformationActivity.this,
					PersonalizedSignatureActivity.class);
			InformationActivity.this.startActivity(intent);
		}
	};

	private View.OnClickListener NClistener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(InformationActivity.this, NameActivity.class);
			InformationActivity.this.startActivity(intent);
		}
	};

	/**
	 * 显示选择对话框
	 */
	private void showDialog() {

		new AlertDialog.Builder(this)
				.setTitle("设置头像")
				.setItems(items, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case 0:
							Intent intentFromGallery = new Intent();
							intentFromGallery.setType("image/*"); // 设置文件类型
							intentFromGallery
									.setAction(Intent.ACTION_GET_CONTENT);
							startActivityForResult(intentFromGallery,
									IMAGE_REQUEST_CODE);
							break;
						case 1:

							Intent intentFromCapture = new Intent(
									MediaStore.ACTION_IMAGE_CAPTURE);
							// 判断存储卡是否可以用，可用进行存储
							if (Tools.hasSdcard()) {

								intentFromCapture.putExtra(
										MediaStore.EXTRA_OUTPUT,
										Uri.fromFile(new File(Environment
												.getExternalStorageDirectory(),
												IMAGE_FILE_NAME)));
							}

							startActivityForResult(intentFromCapture,
									CAMERA_REQUEST_CODE);
							break;
						}
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				}).show();

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (type.equals("DQ")) {
			if (null != data && resultCode == Activity.RESULT_OK) {
				placetext.setText(data.getStringExtra("city"));
			}
		}
		if (type.equals("TX")) {
			// 结果码不等于取消时候
			if (resultCode != RESULT_CANCELED) {

				switch (requestCode) {
				case IMAGE_REQUEST_CODE:
					startPhotoZoom(data.getData());
					break;
				case CAMERA_REQUEST_CODE:
					if (Tools.hasSdcard()) {
						File tempFile = new File(
								Environment.getExternalStorageDirectory()
										+ IMAGE_FILE_NAME);
						startPhotoZoom(Uri.fromFile(tempFile));
					} else {
						Toast.makeText(InformationActivity.this,
								"未找到存储卡，无法存储照片！", Toast.LENGTH_LONG).show();
					}

					break;
				case RESULT_REQUEST_CODE:
					if (data != null) {
						getImageToView(data);
					}
					break;
				}
			}
		}
		super.onActivityResult(requestCode, resultCode, data);

	}

	/**
	 * 裁剪图片方法实现
	 * 
	 * @param uri
	 */
	public void startPhotoZoom(Uri uri) {

		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// 设置裁剪
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片宽高
		intent.putExtra("outputX", 1024);
		intent.putExtra("outputY", 1024);
		intent.putExtra("return-data", true);
		// 系统的裁剪图片默认对图片进行人脸识别，当识别到有人脸时，会按aspectX和aspectY为1来处理，
		// 如果想设置成自定义的裁剪比例，需要设置noFaceDetection为true。
		intent.putExtra("noFaceDetection", true);
		startActivityForResult(intent, 2);
	}

	/**
	 * 保存裁剪之后的图片数据
	 * 
	 * @param picdata
	 */
	private void getImageToView(Intent data) {
		Bundle extras = data.getExtras();
		if (extras != null) {
			Bitmap photo = extras.getParcelable("data");
			@SuppressWarnings("deprecation")
			Drawable drawable = new BitmapDrawable(photo);
			faceImage.setImageDrawable(drawable);
		}
	}
}
