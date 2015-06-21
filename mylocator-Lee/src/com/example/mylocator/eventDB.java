package com.example.mylocator;

import android.os.Bundle;  
import android.os.Environment;
import android.support.v4.app.Fragment;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.Spinner;
import android.widget.Button;  
import android.widget.TextView;
import android.widget.Toast; 
import android.widget.CheckBox;
import android.widget.EditText;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.view.KeyEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.res.AssetManager;

public class eventDB extends Activity{
	//DB
	String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/com.example.mylocator/databases" ;
	//String DB_PATH = "/data/data/com.example.mylocator/databases" ;
	String DB_NAME = "LocatorDB.db";
	//DB
	
    public void prepareDB() {
    	
    	
    	if ((new File(DB_PATH+DB_NAME)).exists() == false) {
    		
//    		Toast.makeText(getActivity(), "NO DATABASE, PREPARING~~", Toast.LENGTH_SHORT).show();
    		
    		File fl = new File(DB_PATH);
    		
    		if (!fl.exists()) {
//    			Toast.makeText(getActivity(), "SETTING DIRECTORY~~", Toast.LENGTH_SHORT).show();
    			fl.mkdir();
    		}

    		try {
//    			Toast.makeText(getActivity(), "SETTING DB COPY~~", Toast.LENGTH_SHORT).show();
    			//InputStream is = getActivity().openFileInput(DB_NAME);
    			InputStream is = getAssets().open(DB_NAME);
    					
    			
    			
//    			Toast.makeText(getActivity(), "DB COPYING~~", Toast.LENGTH_SHORT).show();
    			
    			OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);
//    			Toast.makeText(getActivity(), "SETTING DB FILE~~", Toast.LENGTH_SHORT).show();
    			
    			byte[] buffer = new byte[1024];
    			int length;
    			while ((length = is.read(buffer)) > 0) {
    				os.write(buffer, 0, length);
//    				Toast.makeText(getActivity(), "SETTING DB Writing~~", Toast.LENGTH_SHORT).show();
    			}

    			
    			os.flush();
    			os.close();
    			is.close();
//    			Toast.makeText(getActivity(), "DATABASE PREPARED!!!", Toast.LENGTH_SHORT).show();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} else {
//    		Toast.makeText(getActivity(), "DATABASE EXITS~ >.^", Toast.LENGTH_SHORT).show();
    	}
    	
    }
}
