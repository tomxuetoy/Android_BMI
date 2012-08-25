package com.demo.android.bmi;

import android.util.Log;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bmi extends Activity {
	private static final String TAG = "Bmi";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG, "onCreate");
		setContentView(R.layout.main);
		findViews();
		setListensers();
	}

	public void onStart() {
		super.onStart();
		Log.v(TAG, "onStart");
	}

	public void onResume() {
		super.onResume();
		Log.v(TAG, "onResume");
	}

	public void onPause() {
		super.onPause();
		Log.v(TAG, "onPause");
	}

	public void onStop() {
		super.onStop();
		Log.v(TAG, "onStop");
	}

	public void onRestart() {
		super.onRestart();
		Log.v(TAG, "onReStart");
	}

	public void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy");
	}

	private Button button_calc;
	private EditText field_height;
	private EditText field_weight;

	/*
	 * private TextView view_result; private TextView view_suggest;
	 */

	private void findViews() {
		button_calc = (Button) findViewById(R.id.submit);
		field_height = (EditText) findViewById(R.id.height);
		field_weight = (EditText) findViewById(R.id.weight);
		/*
		 * view_result = (TextView) findViewById(R.id.result); view_suggest =
		 * (TextView) findViewById(R.id.suggest);
		 */
		Log.d(TAG, "find Views");
	}

	// Listen for button clicks
	private void setListensers() {
		button_calc.setOnClickListener(calcBMI);
	}

	private Button.OnClickListener calcBMI = new Button.OnClickListener() {
		public void onClick(View v) {
			// Switch to report page
			Intent intent = new Intent();
			intent.setClass(Bmi.this, Report.class);
			Bundle bundle = new Bundle();
			bundle.putString("KEY_HEIGHT", field_height.getText().toString());
			bundle.putString("KEY_WEIGHT", field_weight.getText().toString());
			intent.putExtras(bundle);
			startActivity(intent);
		}
	};

	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_Quit = Menu.FIRST + 1;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, MENU_ABOUT, 0, "关于...");
		menu.add(0, MENU_Quit, 0, "结束");
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case MENU_ABOUT:
			openOptionsDialog();
			break;
		case MENU_Quit:
			finish();
			break;
		}
		return true;
	}

	private void openOptionsDialog() {
		new AlertDialog.Builder(this)
				.setTitle(R.string.about_title)
				.setMessage(R.string.about_msg)
				.setPositiveButton(R.string.ok_label,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialoginterface, int i) {
							}
						})
				.setNegativeButton(R.string.homepage_label,
						new DialogInterface.OnClickListener() {
							public void onClick(
									DialogInterface dialoginterface, int i) {
								// go to url
								Uri uri = Uri
										.parse(getString(R.string.homepage_uri));
								Intent intent = new Intent(Intent.ACTION_VIEW,
										uri);
								startActivity(intent);
							}
						}).show();
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) {
	 * getMenuInflater().inflate(R.menu.activity_bmi, menu); return true; }
	 */
}
