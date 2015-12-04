package com.example.mylocator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import com.google.android.gms.common.GooglePlayServicesUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends FragmentActivity{
	
	private ViewPager mPager;
	private ArrayList<Fragment> fragmentList;
	private ImageView image;
	private ImageView view1, view2, view3, view4, view5;
	private int currIndex;// current index
	private int bmpW;// width
	private int offset;//
	double MyLatitude;
	double MyLongitude;
	
//	DBAdapter myDB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_locator);
		InitTextView();
		InitImage();
		InitViewPager();
		
        /* Use locationmanager class to acquire GPS location */
        /*acquire a reference to the system Location Manager*/
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        /*Define a listener that responds to location update*/
        LocationListener locationListener = new GPSfunction() {

        	private void makeUseOfNewLocation(Location location) {
				// TODO Auto-generated method stub
				
			}
			public void onStatusChanged(String provider, int status, Bundle extras ){}
        	
        	public void onProviderEnabled(String provider){
        	}
        	
        	public void onProviderDisabled(String provider){
        	}
        };
         // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		
		String LocationMessage = "My current location is: " + "Latitude = " + 
				GPSfunction.getLatitude() + ", " + "Longitude = " + GPSfunction.getLongitude();

        try {
			inPutFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		
		
	}
	public void inPutFile() throws IOException{
		  
		File f = new File("/data/data/com.example.mylocator/files/schedule.txt");
		if (f.exists()) f.delete();
	    	
	   	FileWriter writer = new FileWriter("/data/data/com.example.mylocator/files/schedule.txt", true);
	    writer.write("Maroon 5 Live");
	    writer.write("\r\n");
	    writer.write("Brooklyn");
	    writer.write("\r\n");
	    writer.write("12:25 pm");
	    writer.write("\r\n");
	    writer.close();
	    return ;
	}
		

	public void InitTextView() {
		view1 = (ImageView) findViewById(R.id.img_category);
		view2 = (ImageView) findViewById(R.id.img_search);
		view3 = (ImageView) findViewById(R.id.img_home);
		view4 = (ImageView) findViewById(R.id.img_schedule);
		view5= (ImageView) findViewById(R.id.img_more);
		view1.setOnClickListener(new txListener(0));
		view2.setOnClickListener(new txListener(1));
		view3.setOnClickListener(new txListener(2));
		view4.setOnClickListener(new txListener(3));
		view5.setOnClickListener(new txListener(4));
	}

	public class txListener implements View.OnClickListener {
		private int index = 0;

		public txListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mPager.setCurrentItem(index);
		}
	}
	/*
	 * InitImage
	 */
	public void InitImage() {
		image = (ImageView) findViewById(R.id.img_tab_now);
		bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.tab_bg)
				.getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		offset = (screenW / 5 - bmpW) / 2;

		// imgageview set 1 offset
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		image.setImageMatrix(matrix);
	}
	/*
	 * Initiate ViewPager
	 */
	
	public void InitViewPager() {
		mPager = (ViewPager) findViewById(R.id.tabpager);
		fragmentList = new ArrayList<Fragment>();
		Fragment category = new CategoryFragment();
		Fragment search = new SearchFragment();
		Fragment home= new HomeFragment();
		Fragment schedule = new ScheduleFragment();
		Fragment more = new MoreFragment();
		
		
		fragmentList.add(category);
		fragmentList.add(search);
		fragmentList.add(home);
		fragmentList.add(schedule);
		fragmentList.add(more);

		// ViewPager adapter
		mPager.setAdapter(new MyFragmentPagerAdapter(
				getSupportFragmentManager(), fragmentList));
		mPager.setCurrentItem(0);// the first page
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());//
	}
	
	public class MyOnPageChangeListener implements OnPageChangeListener {
		private int one = offset * 2 + bmpW;// offset

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			Animation animation = new TranslateAnimation(currIndex * one, arg0
					* one, 0, 0);//
			currIndex = arg0;
			animation.setFillAfter(true);//
			animation.setDuration(200);//
			image.startAnimation(animation);//
			int i = currIndex + 1;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}


