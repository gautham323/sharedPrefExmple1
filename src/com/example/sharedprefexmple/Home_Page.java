package com.example.sharedprefexmple;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Home_Page extends Activity {
	public static final String Login = "login";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home__page);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_home__page, menu);
		menu.add(0, 0, 0, "Logout");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Toast.makeText(getApplicationContext(),
					"You are successfully Logout", Toast.LENGTH_LONG).show();
			SharedPreferences sp = getSharedPreferences(Login, 0);
			SharedPreferences.Editor ed = sp.edit();
			ed.putString("username", "");
			ed.putString("password", "");
			ed.commit();

			Intent i = new Intent(getApplicationContext(), MainActivity.class);
			startActivity(i);

			return true;
		}

		return super.onOptionsItemSelected(item);

	}
}
