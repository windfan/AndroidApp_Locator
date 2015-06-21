package com.example.mylocator;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class map extends FragmentActivity {

	
	 private GoogleMap myMap;
	 private double lat; //= GPSfunction.getLatitude(); //call GPSfunction to get the value of latitude
	 private double lng; //= GPSfunction.getLongitude();//call GPSfunction to get the value of longitude
	// private double lat = 40.729405;
	 //private double lng = -73.997476;
	 private LatLng latlng;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.map);
		
		
		 FragmentManager myFragmentManager = getSupportFragmentManager();
         SupportMapFragment mySupportMapFragment = (SupportMapFragment) myFragmentManager
                 .findFragmentById(R.id.map);
         myMap = mySupportMapFragment.getMap();
         myMap.getUiSettings().setZoomControlsEnabled(true);
         myMap.getUiSettings().setCompassEnabled(true);
         myMap.getUiSettings().setRotateGesturesEnabled(true);
         myMap.getUiSettings().setMyLocationButtonEnabled(true);
         Bundle bundle = this.getIntent().getExtras();
        lat= Double.parseDouble(bundle.getString("lat"));
         lng= Double.parseDouble(bundle.getString("lng"));
         Log.i("laginmap",bundle.getString("lat"));
       //  lat=new  Double(bundle.getString("lat"));
        // lng=new Double(bundle.getString("lng"));
         latlng = new LatLng(lat,lng);
         myMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
         myMap.moveCamera(CameraUpdateFactory.zoomTo(18));
         Marker marker = myMap.addMarker(new MarkerOptions()
         .position( latlng)
         .icon(BitmapDescriptorFactory.fromResource(R.drawable.arrow2)));
	}
	
}




