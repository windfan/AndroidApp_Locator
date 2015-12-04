package com.example.mylocator;

import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class EventDetail extends Activity{
	private Button but1;
	private TextView name;
	private TextView location;
	private TextView time;
	private ImageButton map1;
	private String key_lat,key_lng;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eventdetail);
		
		Bundle bundle = this.getIntent().getExtras();
		//name
		String key_name = bundle.getString("key_name");
		TextView view1 = (TextView) findViewById(R.id.textView_detail_name);
		view1.setText(key_name);
		//region
		String region = bundle.getString("key_region");
		TextView view2 = (TextView) findViewById(R.id.textView_detail_region);
		view2.setText(region);
		//time
		String key_time = bundle.getString("key_time");
		TextView view3 = (TextView) findViewById(R.id.textView_time_answer);
		view3.setText(key_time);
		//date
		String key_date = bundle.getString("key_date");
		TextView view4 = (TextView) findViewById(R.id.textView_time_date);
		view4.setText(key_date);
		//
		String key_addr = bundle.getString("key_addr");
		TextView view5 = (TextView) findViewById(R.id.textView_addr_answer);
		view5.setText(key_addr);
		key_lat = bundle.getString("key_lat");
		key_lng = bundle.getString("key_lng");

		
		
		map1=(ImageButton) findViewById(R.id.imageButton1);
		map1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(EventDetail.this, map.class);
				Bundle bundle= new Bundle();
				bundle.putString("lat",key_lat);
				bundle.putString("lng", key_lng);
				Log.i("latis", key_lat);
				intent.putExtras(bundle);
				startActivity(intent);	
			}
		});
		

		but1=(Button) findViewById(R.id.button1);
	
		but1.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
		    	name=(TextView)findViewById(R.id.textView_detail_name);
		    	location=(TextView)findViewById(R.id.textView_detail_region);
		    	time=(TextView)findViewById(R.id.textView_time_answer);
		    	but1.setText("done !");
		    	return ;
				 
			}
		});
	}
}