package com.example.hackathon;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.graphics.PorterDuff;

public class CustomMapActivity extends Activity {

	FrameLayout frame;
	ArrayList<Person> persons = new ArrayList<Person>();

	CustomMapActivity activity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		frame = (FrameLayout) findViewById(R.id.frameLayout);

		addPerson(0, "Eric");

		findViewById(R.id.button_add).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Person person = persons.get(0);
				person.moveButton( person.getX() + 5f, person.getY() +  5f);
				person.setFriendly();
			}
		});

	}

	public boolean addPerson(int id, String name) {
		Person person = new Person(this);
		return persons.add(person);
	}

	public class Person {
		int id;
		String name;
		Context context;
		Button button;
		
		int[] color ;
		public Person(Context context) {
			this.context = context;
			
			color = context.getResources().getIntArray(R.array.colors); // get Color array
			
			button = new Button(context);

			frame.addView(button);
			
			button.setX(50f);
			button.setY(50f);
			ViewGroup.LayoutParams params = button.getLayoutParams();
			params.height = 50;
			params.width = 50;
			button.setLayoutParams(params);
			
			button.getBackground().setColorFilter(color[0], PorterDuff.Mode.MULTIPLY);
			
		}

		public void setEnemy()
		{	
			button.getBackground().setColorFilter(color[1], PorterDuff.Mode.MULTIPLY);
		}
		
		public void setFriendly()
		{	
			button.getBackground().setColorFilter(color[2], PorterDuff.Mode.MULTIPLY);
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

}
