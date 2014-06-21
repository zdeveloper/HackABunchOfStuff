package com.example.hackathon;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.graphics.PorterDuff;

public class CustomMapActivity extends Activity implements LocationListener {

	private FrameLayout frame;
	private ArrayList<Person> persons = new ArrayList<Person>();
	private ArrayList<User> users = new ArrayList<User>();

	// private CustomMapActivity activity = this;

	private LocationManager locationManager;

	private Person self;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		frame = (FrameLayout) findViewById(R.id.frameLayout);
		self = new Person(this);

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				1000, 1, this);

		findViewById(R.id.button_add).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Person person = persons.get(0);
				person.moveButton(person.getX() + 5f, person.getY() + 5f);
				person.setFriendly();
			}
		});

		Thread otherUsersDataUpdate = new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						sleep(1000);
						getDattafromDataBase();
					}
				} catch (InterruptedException e) {
					Log.d("DEBUG", "Hah something went wrong!");
				}

			}
		};
		otherUsersDataUpdate.start();

		Thread currentUserDataUpdate = new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						sleep(1000);
						// sendDataToDatabase(new User(username, password,
						// email, city, parseGeoPoint, channel, precinct, type,
						// string));
					}
				} catch (InterruptedException e) {
					Log.d("DEBUG", "Hah something went wrong!");
				}

			}
		};
		currentUserDataUpdate.start();
	}

	public Person addPerson() {
		Person person = new Person(this);
		persons.add(person);
		return person;
	}

	public void addImg() {
		ImageView imageView = new ImageView(this);
		imageView.setImageResource(R.drawable.person_blue);
		frame.addView(imageView);

		ViewGroup.LayoutParams params = imageView.getLayoutParams();
		params.height = 250;
		params.width = 250;
		imageView.setLayoutParams(params);

	}

	public class Person {
		int id;
		String name;
		Context context;
		Button button;

		int[] color;

		public Person(Context context) {
			this.context = context;

			color = context.getResources().getIntArray(R.array.colors); // get
																		// Color
																		// array
			button = new Button(context);

			frame.addView(button);

			button.setX(50f);
			button.setY(50f);
			ViewGroup.LayoutParams params = button.getLayoutParams();
			params.height = 50;
			params.width = 50;
			button.setLayoutParams(params);

			button.getBackground().setColorFilter(color[0],
					PorterDuff.Mode.MULTIPLY);
		}

		public void setEnemy() {
			button.getBackground().setColorFilter(color[1],
					PorterDuff.Mode.MULTIPLY);
		}

		public void setFriendly() {
			button.getBackground().setColorFilter(color[2],
					PorterDuff.Mode.MULTIPLY);
		}

		public Button getbutton() {
			return button;
		}

		private void moveButton(float x, float y) {
			button.setX(x);
			button.setY(y);
		}

		public float getX() {
			return button.getX();
		}

		public float getY() {
			return button.getY();
		}

	}
	
	public void populateMap()
	{
		for (User user : users) {
			Person person = addPerson();
			if(user.getType().equals("Friend"))
			{
				person.setFriendly();
			} else if(user.getType().equals("Enemy"))
			{
				person.setEnemy();;
			}
		}
	}

	@Override
	public void onLocationChanged(Location loc) {
		int c = 100;
		double Latr = Math.PI * loc.getLatitude() / 180;
		double Longr = Math.PI * loc.getLongitude() / 180;

		int R = 6371;
		float x = (float) (R / c * Math.cos(Latr) * Math.cos(Longr));
		float y = (float) (R / c * Math.cos(Latr) * Math.sin(Longr));
		self.moveButton(x, y);
	}

	@Override
	public void onProviderDisabled(String provider) {
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getDattafromDataBase() {

		ParseQuery query = new ParseQuery("User");
		// query.whereNotEqualTo("bldName", "");
		// this runs in the background and fires a callback when data is
		// retrieved
		query.findInBackground(new FindCallback() {

			public void done(List usersInfo, ParseException e) {
				try {
					for (int i = 0; i < usersInfo.size(); i++) {
						ParseObject obj = (ParseObject) usersInfo.get(i);
						User user = new User(obj.getString("username"), obj
								.getString("password"), obj.getString("email"),
								obj.getString("city"), obj
										.getParseGeoPoint("location"), obj
										.getString("channel"), obj
										.getString("precinct"), obj
										.getString("type"),
								"Badges Not Implemented");
						users.add(user); // adding user
					}

				} catch (Exception e2) {

				}
			}
		});
		populateMap();
	}

	public void sendDataToDatabase(User user) {
		ParseObject query = new ParseObject("User");
		query.put("username", user.getUsername());
		query.put("password", user.getPassword());
		query.put("type", user.getType());
		query.put("location", user.getLocation());
		query.put("channel", user.getChannel());
		query.put("city", user.getCity());
		query.saveInBackground();
	}

	@Override
	public void onProviderEnabled(String provider) {
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

}
