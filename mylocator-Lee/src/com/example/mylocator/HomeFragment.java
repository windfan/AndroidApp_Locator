package com.example.mylocator;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment{  
    RelativeLayout homeButton;  
    RelativeLayout homeButton2;
    RelativeLayout homeButton3;
    RelativeLayout homeButton4;
    RelativeLayout homeButton5;
    TextView myTextView;
    ListView home_list;

	private double lat; //call GPSfunction to get the value of latitude
	private double lng;//call GPSfunction to get the value of longitude
	DBAdapter myDB;
	public String addr;
	public String lat_reading;
	public String lng_reading;

//    @SuppressWarnings("null")
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        final View rootView = inflater.inflate(R.layout.home, container, false);//get the layout file
//		Toast.makeText(getActivity(), "CLICKED!!!", Toast.LENGTH_SHORT).show();
		openDB();
		myDB.insertRow(2014, "Dec", 16, "PM", "12", "25", "Maroon 5 Live @ Brooklyn", "MUSIC", 2, "630 Atlantic Ave, Brooklyn, NY 11217", "Brooklyn", 1, 40.682769, -73.974702, "Maroon 5 just comes to Brooklyn!", 0, "NULL", 2, "dfger");
		myDB.insertRow(2014, "Dec", 17, "PM", "6", "30", "Holiday Sing with Orchestra of ST Luke's", "MUSIC", 2, "450 West 37th Street, Manhattan, NY 10018", "Manhattan", 1, 40.756351, -73.997316, "Orchestra of St. Luke's popular Holiday Sing returns, bringing voices of the community together in a celebration of the season.", 0, "NULL", 2, "dfger");
		myDB.insertRow(2014, "Dec", 23, "PM", "7", "30", "Jazz for Young People presents Swingin in the Holiday", "MUSIC", 2, "61 West 62 Street, New York, NY 10023", "Manhattan", 1, 40.771251, -73.982909, "This all-ages jazz concert will ring in the holidays with a swinging collection of the best loved songs of the season, featuring: Jazzmeia Horn (vocals)", 1, "NULL", 2, "dfger");
		myDB.insertRow(2014, "Dec", 26, "AM", "9", "00", "Psychic TV", "MUSIC", 2, "165 Banker St, Brooklyn, NY 11222", "Brooklyn", 1, 40.724122, -73.955196, "The art-rock luminaries of Psychic TV, fronted by cultural engineer Genesis Breyer P-Orridge, return to the stage in support of a new album called Snakes (for which the band has released a trailer).", 1, "NULL", 2, "dfger");
		myDB.insertRow(2014, "Dec", 18, "PM", "7", "00", "The New Standards Holiday Show", "MUSIC", 2, "61 West 62 Street, New York, NY 10023", "Manhattan", 1, 40.771251, -73.982909, "Described as a little lounge, a little punk, a little rock, and a whole lot of cool, this trio featuring piano, stand-up bass, and vibraphone reinvents their favorite songs with panache", 1, "NULL", 2, "dfger");
		myDB.insertRow(2014, "Dec", 20, "AM", "9", "00", " Macy's holiday windows", "ART", 1, "151 W 34th St, Midtown West, New York", "Manhattan", 1, 40.750999, -73.989537, "Cross Street:between Sixth and Seventh Aves", 1, "NULL", 2, "dfger");
		myDB.insertRow(2014, "Dec", 24, "AM", "11", "00", "Union Square Holiday Market", "FESTIVAL", 4, "1 Union Sq W, New York, NY  10003-3303 United State", "Manhattan", 1, 40.736711, -73.990225, "Cross Street:between Broadway and Park Ave South", 1, "NULL", 2, "dfger");
		myDB.insertRow(2014, "Dec", 25, "AM", "10", "00", "Artists & Fleas - Chelsea Market", "ART", 1, "75 Ninth Ave, Chelsea North, 10011", "Manhattan", 1, 40.742507, -74.005958, "Cross Street:between 15th and 16th Sts", 1, "NULL", 2, "dfger");
		myDB.insertRow(2015, "Jan", 1, "AM", "00", "00", "New Year's Eve Fireworks in Prospect Park", "FESTIVAL", 4, "Prospect Park, Brooklyn", "Manhattan", 1, 40.660143, -73.968967, "Cross Street:between Prospect Park Southwest and Ocean Ave", 1, "NULL", 2, "dfger");
		myDB.insertRow(2015, "Jan", 1, "AM", "00", "00", "New Year's Eve Fireworks in Time Square", "FESTIVAL", 4, "Times Square, Manhattan, NY 10036", "Manhattan", 1, 40.758858, -73.985110, "The most famous spot in the world to celebrate New Year!", 1, "NULL", 2, "dfger");
		myDB.insertRow(2015, "Feb", 22, "PM", "01", "30", "Chinatown Lunar New Year Parade & Festival", "PARADE", 5, "250 E Houston St, New York, NY 10002", "Manhattan", 1, 40.721971, -73.985848, "A parade full of Chinese costume and events!", 1, "NULL", 2, "dfger");
		myDB.insertRow(2015, "Mar", 1, "AM", "09", "00", "Bank of America Winter Village at Bryant Park Rink", "FESTIVAL", 4, "Bryant Park, New York, NY", "Manhattan", 1, 40.753569, -73.983249, "The Rink is the centerpiece of Bank of America Winter Village at Bryant Park. The 170' x 100' rink features free admission ice skating.", 1, "NULL", 2, "dfger");

		// Query for the record we just added.
		// Use the ID:
        Cursor cursor1 = myDB.getRow(1);
//        String testname = cursor1.getString(DBAdapter.COL_NAME);
		// Reset cursor to start, checking to see if there's data:
		if (cursor1.moveToFirst()) {
			do {
//				// Process the data:
				//name
				String name = cursor1.getString(DBAdapter.COL_NAME);
				TextView testview_name = (TextView) rootView.findViewById(R.id.event_name1);
				testview_name.setText(name);
				//hour
				String hour = cursor1.getString(DBAdapter.COL_HOUR);
				//minute
				String min = cursor1.getString(DBAdapter.COL_MINUTE);
				//am or pm
				String m = cursor1.getString(DBAdapter.COL_M);

				String time = hour + ":" + min + " " + m;
				TextView textview_time = (TextView) rootView.findViewById(R.id.event_time);
				textview_time.setText(time);
				//month
				String month = cursor1.getString(DBAdapter.COL_MONTH);					
				//date
				String date = cursor1.getString(DBAdapter.COL_DATE);
				//year
				String year = cursor1.getString(DBAdapter.COL_YEAR);

				String day = month + " " + date + " " + year;
				TextView textview_day = (TextView) rootView.findViewById(R.id.event_date);
				textview_day.setText(day);
				//region
				String region = cursor1.getString(DBAdapter.COL_REGION_AREA);
				TextView testview_region = (TextView) rootView.findViewById(R.id.event_region1);
				testview_region.setText(region);
				
				addr = cursor1.getString(DBAdapter.COL_ADDR);
				lat_reading = cursor1.getString(DBAdapter.COL_GPS_LA);
				lng_reading = cursor1.getString(DBAdapter.COL_GPS_LO);
			} while(cursor1.moveToNext());
		}

		cursor1.close();
		closeDB();
		lat = GPSfunction.getLatitude(); //call GPSfunction to get the value of latitude
		lng = GPSfunction.getLongitude();//call GPSfunction to get the value of longitude
//		String lat_string = Double.toString(lat);
		String lng_string = Double.toString(lng);
//		TextView view1 = (TextView) rootView.findViewById(R.id.latstring);
//		view1.setText(lat_string);
//		TextView view2 = (TextView) rootView.findViewById(R.id.lngstring);
//		view2.setText(lng_string);
//		populateListViewFromDB();
        homeButton = (RelativeLayout) rootView.findViewById(R.id.event_frame1);//button for Music 
        homeButton2 = (RelativeLayout)rootView.findViewById(R.id.event_frame2);// button for Art
        homeButton3 = (RelativeLayout)rootView.findViewById(R.id.event_frame3);// button for parade
        homeButton4 = (RelativeLayout)rootView.findViewById(R.id.event_frame4);// button for festival
        homeButton5 = (RelativeLayout)rootView.findViewById(R.id.event_frame5);// button for family event

        homeButton.setOnClickListener(new View.OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	Intent intent = new Intent();
            	intent.setClass(getActivity(),EventDetail.class);
            	Bundle bundle= new Bundle();
            	TextView name = (TextView) rootView.findViewById(R.id.event_name1);
            	TextView region = (TextView) rootView.findViewById(R.id.event_region1);
            	TextView time = (TextView) rootView.findViewById(R.id.event_time);
            	TextView date = (TextView) rootView.findViewById(R.id.event_date);

 //           	TextView m = (TextView) rootView.findViewById(R.id.event_m1);

            	bundle.putString("key_name", name.getText().toString());
            	bundle.putString("key_region", region.getText().toString());
            	bundle.putString("key_time", time.getText().toString());
            	bundle.putString("key_day", date.getText().toString());
            	bundle.putString("key_addr", addr);
            	bundle.putString("key_lat",  Double.valueOf(40.682990).toString());
            	bundle.putString("key_lng", Double.valueOf(-73.974780).toString());

//            	bundle.putString("key_m", m.getText().toString());

            	intent.putExtras(bundle);
            	startActivity(intent);
//                Toast.makeText(HomeFragment.this.getActivity(), "button1 is click! (Music)", Toast.LENGTH_SHORT).show();  
            }  
        }); 		
        return rootView;  
    }
//	private void populateListViewFromDB() {
//		Cursor cursor =myDB.getAllRows();
//		
//		//allow activity to manage lifetime of the cursor
//		getActivity().startManagingCursor(cursor);
//		
//		
//		//setup mapping from cursor to view fields
//		String[] fromFieldNames = new String[]
//				{DBAdapter.NAME, DBAdapter.REGION_AREA, DBAdapter.HOUR, DBAdapter.MINUTE, DBAdapter.M};
//		int[] toViewIDs = new int[]
//				{R.id.event_name, R.id.event_region, R.id.event_hour, R.id.event_minute, R.id.event_m};
//
//		
//		
//		//create the adapter to may the columns of the DB onto element in UI
//		SimpleCursorAdapter myCursorAdapter = 
//				new SimpleCursorAdapter(
//						getActivity().getApplicationContext(),						//Context
//						R.layout.eventframe,		//Row layout template
//						cursor,						//cursor (set to DB records to map)
//						fromFieldNames,				//DB column name
//						toViewIDs				//View ID to put information in
//						);
//		//set adapter for the list view
//		ListView  myList = (ListView) getView().findViewById(R.id.listView_home);
//		myList.setAdapter(myCursorAdapter);
//	}
//
	@Override
	public void onDestroy(){
		super.onDestroy();
		
		closeDB();
	}
	

	private void openDB() {
		myDB = new DBAdapter(getActivity());
		myDB.open();
	}
	
	private void closeDB() {
		myDB.close();  
	}

}  