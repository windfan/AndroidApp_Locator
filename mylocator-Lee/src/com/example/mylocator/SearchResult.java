package com.example.mylocator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SearchResult extends Activity{
	private RelativeLayout r1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		r1=(RelativeLayout)findViewById(R.id.result_frame1);
		r1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SearchResult.this, EventDetail.class);
				Bundle bundle = new Bundle();
				bundle.putString("key_name", "The New Standards¡¯ Holiday Show");
		    	bundle.putString("key_region", "Manhattan");
		    	bundle.putString("key_addr", "61 West 62 Street, New York, NY 10023");
		    	bundle.putString("key_time","18:30");
		    	bundle.putString("key_date", "Dec18");
		    	bundle.putString("key_lat", Double.valueOf(40.771316).toString());
		    	bundle.putString("key_lng", Double.valueOf(-73.982888).toString());
		    
		    	intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
	}

}
