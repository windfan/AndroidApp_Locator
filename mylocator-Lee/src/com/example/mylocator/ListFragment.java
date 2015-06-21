package com.example.mylocator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
  
public class ListFragment extends Fragment{  
   private TextView name,region;
    RelativeLayout myTextView;
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View rootView = inflater.inflate(R.layout.list, container, false);//get the layout file  
          myTextView=(RelativeLayout) rootView.findViewById(R.id.result_frame1);
          name = (TextView) rootView.findViewById(R.id.result_name1);
	    	 region = (TextView) rootView.findViewById(R.id.result_region1);
          myTextView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getActivity(),EventDetail.class);
				//intent.setClass(ListFragment.this, EventDetail.class);
		      	Bundle bundle= new Bundle();
		    	
//		           	TextView m = (TextView) rootView.findViewById(R.id.event_m1);

		    	bundle.putString("key_name", name.getText().toString());
		    	bundle.putString("key_region", region.getText().toString());
//		    	bundle.putString("key_m", m.getText().toString());

		    	intent.putExtras(bundle);
				startActivity(intent);
			}
		});
          
        return rootView;  
    }  
}  