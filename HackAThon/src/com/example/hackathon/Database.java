package com.example.hackathon;


import java.util.List;

import android.app.Activity;
import android.content.Context;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.util.Log;


public class Database {
	
	
	Activity activity;
	Context context;

	@SuppressWarnings("unchecked")
	public Database(Activity activity) {
		
		
		this.activity = activity;
		this.context = activity.getApplicationContext();

		Log.d("DEBUG", "Test ");

		ParseQuery query = new ParseQuery("incident");
		// query.whereNotEqualTo("bldName", "");
		//this runs in the background and fires a callback when data is retrieved
		query.findInBackground(new FindCallback() {

			public void done(List scoreList, ParseException e) {
				try{
					for (int i = 0; i < scoreList.size(); i++) {
						ParseObject obj = (ParseObject)scoreList.get(i);
						Log.d("DEBUG", obj.getObjectId() );
					}	
					
				} catch(Exception e2)
				{
					
				}
			}
		});
	}


}
