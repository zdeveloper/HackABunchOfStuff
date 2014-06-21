package com.example.hackathon;

import android.app.Activity;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseAnalytics;

import android.util.Log;


public class Database {
	
	
	Activity activity;
	Context context;

	public Database(Activity activity) {
		
		
		this.activity = activity;
		this.context = activity.getApplicationContext();

		Log.d("DEBUG", "Test ");


	}


}
