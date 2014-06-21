package com.example.hackathon;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.util.Log;


public class Database {
	
	
	IncidentsActivity activity;
	Context context;
	
	@SuppressWarnings("unchecked")
	public Database(final IncidentsActivity activity) {
		
		
		this.activity = activity;
		this.context = activity.getApplicationContext();

		Log.d("DEBUG", "Test ");

		
	}




}
