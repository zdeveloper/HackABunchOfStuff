package com.example.hackathon;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {

	Button map, list, video;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		findViewById(R.id.button_map).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this, CustomMapActivity.class);
				startActivity(i);
			}
		});
		
		findViewById(R.id.button_list_view).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this, IncidentsActivity.class);
				startActivity(i);
			}
		});
		
		findViewById(R.id.button_hangout).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent sky = new Intent("android.intent.action.VIEW", Uri.parse("https://talkgadget.google.com/hangouts/extras/talk.google.com/myhangout"));
				startActivity(sky);
			}
		});
		
	}
}
