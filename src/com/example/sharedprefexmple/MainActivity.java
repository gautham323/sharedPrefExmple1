package com.example.sharedprefexmple;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText username, password;
	String uname, pwd;
	Button btn;
	public static final String Login = "login";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		username = (EditText) findViewById(R.id.editTextUsername);
		password = (EditText) findViewById(R.id.editTextPwd);
		btn = (Button) findViewById(R.id.buttonLogin);
		btn.setText("Login");

		SharedPreferences settings = getSharedPreferences(Login, 0);
		uname = settings.getString("username", "");
		pwd = settings.getString("password", "");
		username.setText(uname);
		password.setText(pwd);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String uname = username.getText().toString().trim();
				String pass = password.getText().toString().trim();
				if (uname.equals("admin") && pass.equals("admin")) {
					Intent i = new Intent(getApplicationContext(),
							Home_Page.class);
					startActivity(i);
					Toast.makeText(getApplicationContext(),
							"Your are successfully logedin", Toast.LENGTH_LONG)
							.show();

				} else {
					Toast.makeText(getApplicationContext(),
							"Wrong UserName and Password", Toast.LENGTH_LONG)
							.show();
				}

			}
		});

	}

	@Override
	protected void onStop() {
		super.onStop();
		SharedPreferences s = getSharedPreferences(Login, 0);
		SharedPreferences.Editor editor = s.edit();
		editor.putString("username", username.getText().toString().trim());
		editor.putString("password", password.getText().toString().trim());
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
