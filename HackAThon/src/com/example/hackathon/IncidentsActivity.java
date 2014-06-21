package com.example.hackathon;

import com.parse.Parse;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class IncidentsActivity extends Activity {

	ListView incidentListView;
	Database db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Parse.initialize(this, "ugI5MBgBhmSwrjKRZR0SRQHdiuJktk256r4xEAzZ", "WpLvtFiNRSmbkVSjdEkUOw9gAPYirYHw920g81Mo");
		
		setContentView(R.layout.activity_incidents);
		db = new Database(this);

		incidentListView = (ListView) findViewById(R.id.incident_List);
		
		
		String[] incidents = { "Incident 1", "Incident 2" };
		

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				incidents);
		
		incidentListView.setAdapter(adapter);

	}

}
