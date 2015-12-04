package com.example.mylocator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;



  
public class SearchFragment extends Fragment{  
	private Spinner spinner_month, spinner_date, spinner_hour, spinner_min, spinner_category;
	private CheckBox chk_manhattan, chk_brooklyn, chk_queens, chk_bronx;
	private EditText editText_search_name;
	private Button btnsearch;
	private View rootView;
	DBAdapter myDB;

	//DB
	String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/com.example.mylocator/databases" ;
	//String DB_PATH = "/data/data/com.example.mylocator/databases" ;
	String DB_NAME = "LocatorDB.db";
	//DB

    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        rootView = (View) inflater.inflate(R.layout.search, container, false);//get the layout file          
        
        btnsearch = (Button) rootView.findViewById(R.id.button_search);
        
        btnsearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getActivity(), SearchResult.class);
				startActivity(intent);
			}
		});
        
        
        
    	return rootView;          
    }
}  