package com.example.hackathon;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListPopupWindow;
import android.widget.ListView;

public class CustomMapActivity extends Activity {

	FrameLayout frame;
	ArrayList<Person> persons = new ArrayList<Person>();
	ListView lv ;

	CustomMapActivity activity = this;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		
		
		
		
		
		frame = (FrameLayout) findViewById(R.id.frameLayout);
		final Context context = CustomMapActivity.this;
		//addPerson(0, "Eric");
		
		
		lv = (ListView) findViewById(R.id.listView);
		lv.setVisibility(View.GONE);
		findViewById(R.id.button_friend).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startDialog();
			}
		});
		
		findViewById(R.id.button_foe).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startFoeDialog();
			}
		});
		
		findViewById(R.id.button_flag).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startFlagDialog();

			}
		});
	}
	
	
private void startDialog(){
	
	String friendBtns[] = {"Default","Man Down","Need Assistance"};
	 AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("FRIEND")
	           .setItems(friendBtns, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int which) {
	               // The 'which' argument contains the index position
	               // of the selected item
	           }
	    });
	   builder.create();
	   builder.show();
}

private void startFoeDialog(){
	String friendBtns[] = {"Identified","Engaged","Incapacitated"};
	 AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("FOE")
	           .setItems(friendBtns, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int which) {
	               // The 'which' argument contains the index position
	               // of the selected item
	           }
	    });
	   builder.create();
	   builder.show();
}

private void startFlagDialog(){
	String friendBtns[] = {"Person of Interest","Point of Int","Hazard PoI"};
	 AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("FOE") 
	           .setItems(friendBtns, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int which) {
	               // The 'which' argument contains the index position
	               // of the selected item
	           }
	    });
	   builder.create();
	   builder.show();
}
	
//	public void showList(Context context, Button friendBtns[]){
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, android.R.id.text1,STRING[]);
//
//	}

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
