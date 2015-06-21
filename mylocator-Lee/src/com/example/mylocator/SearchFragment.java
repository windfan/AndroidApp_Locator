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

    	//addListenerOnButton();
        
        
        btnsearch = (Button) rootView.findViewById(R.id.button_search);
        
        btnsearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getActivity(), SearchResult.class);
				startActivity(intent);
//				Toast.makeText(getActivity(), "CLICKED!!!", Toast.LENGTH_SHORT).show();
//				long newId = myDB.insertRow(2015, 3, 11, "AM", "8", "30", "123", "MUSIC", 2, "5306 4th Ave", "Manhattan", 1, 43.76, 32.65, "Awesome", 1, "NULL", 2, "dfger");
//				
//				// Query for the record we just added.
//				// Use the ID:
//				Cursor cursor = myDB.getRow(newId);
//				getSearchResult();
			}
		});
        
        
        
    	return rootView;          
    }
    
    
    //exe DB
//    public void getSearchResult(){
//    	Toast.makeText(getActivity(), "s'up??", Toast.LENGTH_LONG).show();
//    	/*
//    	editText_search_name = (EditText) rootView.findViewById(R.id.editText_search_name);  
//    	spinner_month = (Spinner) rootView.findViewById(R.id.spinner_month);
//    	spinner_date = (Spinner) rootView.findViewById(R.id.spinner_date);
//    	spinner_hour = (Spinner) rootView.findViewById(R.id.spinner_hour);
//    	spinner_min = (Spinner) rootView.findViewById(R.id.spinner_min);
//    	spinner_category = (Spinner) rootView.findViewById(R.id.spinner_category);
//    	chk_manhattan = (CheckBox) rootView.findViewById(R.id.chk_manhattan);
//    	chk_brooklyn = (CheckBox) rootView.findViewById(R.id.chk_brooklyn);
//    	chk_queens = (CheckBox) rootView.findViewById(R.id.chk_queens);
//    	chk_bronx = (CheckBox) rootView.findViewById(R.id.chk_bronx);
//*/
//    	File f = new File(DB_PATH + DB_NAME);
//    	
//    	if (!f.exists()) {
//    	Toast.makeText(getActivity(), "NO DB!!!!!!!", Toast.LENGTH_SHORT).show();
//    		prepareDB();
//    	}   	
//    	
//    	
//    	 Toast.makeText(getActivity(), "=====Calculating=====", Toast.LENGTH_SHORT).show();
//    	 SQLiteDatabase db = getActivity().openOrCreateDatabase(DB_PATH+DB_NAME, Context.MODE_PRIVATE, null);
//    	 
//    	 Toast.makeText(getActivity(), "-----No Selecting-----", Toast.LENGTH_SHORT).show();
//
//    	 
// 		Cursor c = db.rawQuery("SELECT * FROM Events", new String[]{});  
// 		
// 		int row_num = c.getCount();
// 		
// 		if(row_num !=0){
//         	c.moveToFirst();
//         	for(int i = 0; i < row_num; i++){
//         		int year = c.getInt(0);
//         		int mon = c.getInt(1); 
//         		int date = c.getInt(2);
//         		String m = c.getString(3);
//         		String hour = c.getString(4);
//         		String min = c.getString(5);
//         		String name = c.getString(6);
//         		String type = c.getString(7);
//         		String area = c.getString(10);
//                  		
//         		Toast.makeText(getActivity(), 
//         				"Time: <" + year + "." + mon + "." + date + " > " + m 
//         				+ " < " + hour + ":" + min + " >" + "\n" 
//         				+ "EVENT NAME: " + name + "\n" + "Catagory: " + type + "\n" 
//         				+ "AREA: <" + area + " >",
//         				Toast.LENGTH_LONG).show();
//         		
//         		
//         		c.moveToNext();
//         		
//         	}
//         } 
//    	 
//    	//SQLiteDatabase db = openOrCreateDatabase(DB_PATH+DB_NAME, Context.MODE_PRIVATE, null);
//    	
//    }
//    
//  //find DB
//    public void prepareDB() {
//    	
//    	
//    	if ((new File(DB_PATH+DB_NAME)).exists() == false) {
//    		
//    		Toast.makeText(getActivity(), "NO DATABASE, PREPARING~~", Toast.LENGTH_SHORT).show();
//    		
//    		File fl = new File(DB_PATH);
//    		
//    		if (!fl.exists()) {
//    			Toast.makeText(getActivity(), "SETTING DIRECTORY~~", Toast.LENGTH_SHORT).show();
//    			fl.mkdir();
//    		}
//
//    		try {
//    			Toast.makeText(getActivity(), "SETTING DB COPY~~", Toast.LENGTH_SHORT).show();
//    			//InputStream is = getActivity().openFileInput(DB_NAME);
//    			InputStream is = getActivity().getAssets().open(DB_NAME);
//    					
//    					//context.getAssets().open(DB_NAME);
//    			
//    			
//    			Toast.makeText(getActivity(), "DB COPYING~~", Toast.LENGTH_SHORT).show();
//    			
//    			OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);
//    			Toast.makeText(getActivity(), "SETTING DB FILE~~", Toast.LENGTH_SHORT).show();
//    			
//    			byte[] buffer = new byte[1024];
//    			int length;
//    			while ((length = is.read(buffer)) > 0) {
//    				os.write(buffer, 0, length);
//    				Toast.makeText(getActivity(), "SETTING DB Writing~~", Toast.LENGTH_SHORT).show();
//    			}
//
//    			
//    			os.flush();
//    			os.close();
//    			is.close();
//    			Toast.makeText(getActivity(), "DATABASE PREPARED!!!", Toast.LENGTH_SHORT).show();
//    		} catch (Exception e) {
//    			e.printStackTrace();
//    		}
//    	} else {
//    		Toast.makeText(getActivity(), "DATABASE EXITS~ >.^", Toast.LENGTH_SHORT).show();
//    	}
//    	
//    }
    

}  