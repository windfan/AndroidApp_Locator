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
	String DB_NAME = "LocatorDB.db";
	//DB
	
    public void prepareDB() {
    	
    	
    	if ((new File(DB_PATH+DB_NAME)).exists() == false) {
    		
    		
    		File fl = new File(DB_PATH);
    		
    		if (!fl.exists()) {
    			fl.mkdir();
    		}

    		try {

    			InputStream is = getAssets().open(DB_NAME);
    					    			
    			OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);
    			
    			byte[] buffer = new byte[1024];
    			int length;
    			while ((length = is.read(buffer)) > 0) {
    				os.write(buffer, 0, length);
    			}

    			
    			os.flush();
    			os.close();
    			is.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} 	
    }
}
