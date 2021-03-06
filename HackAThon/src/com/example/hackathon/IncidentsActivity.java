package com.example.hackathon;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class IncidentsActivity extends Activity {

	ListView incidentListView;

	private ArrayList<Incident>incidents = new ArrayList<Incident>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_incidents);

		incidentListView = (ListView) findViewById(R.id.incident_List);
		queryParse();

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void queryParse() {
		
		ParseQuery query = new ParseQuery("Incident");
		// query.whereNotEqualTo("bldName", "");
		//this runs in the background and fires a callback when data is retrieved
		query.findInBackground(new FindCallback() {

			public void done(List incidentList, ParseException e) {
				try{
					for (int i = 0; i < incidentList.size(); i++) {
						ParseObject obj = (ParseObject)incidentList.get(i);
						
						Incident incident = new Incident(obj.getString("type"),
													obj.getString("description"),
													obj.getParseGeoPoint("location") .getLongitude(), 
													obj.getParseGeoPoint("location").getLatitude(),
													obj.getObjectId(),
													obj.getString("googleHangout"));
						incidents.add(incident);
						Log.d("DEBUG", obj.getString("description"));
					}	

					populateList();


				} catch(Exception e2)
				{
					
				}
			}
		});
		
	}
	
	public void populateList(){
		
		//String[] incidents = { "Incident 1", "Incident 2" };
		
		Log.d("DEBUG", "Hello" + getIncidents().toString());
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				getIncidents());
		
		incidentListView.setAdapter(adapter);
		
		incidentListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long arg3) {
				startDialog(position);
			}
		});
	}

	
	public String[] getIncidents() {
		String[] returnVal = new String[incidents.size()];
		int i=0;
		for (Incident incident : incidents) {
			returnVal[i++]= new String((i + ": " + incident.getDescription() ));
		}
		return returnVal;
	}

	public void setIncidents(ArrayList<Incident> incidents) {
		this.incidents = incidents;
	}
	
	private void startDialog(int i)
	{
		AlertDialog.Builder builder = new Builder(this);
		Dialog dialog;
		builder.setTitle( incidents.get(i).getType());
		builder.setMessage(incidents.get(i).getDescription() + "\n" + "Lat: " +incidents.get(i).getLatitude() + " Long: "+ incidents.get(i).getLongitude());
		
		builder.setPositiveButton("OK", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		
		dialog = builder.create();
		dialog.show();
		
	}
	
	
	
}
