package com.example.mylocator;

import java.io.File;

import android.content.Intent;
import android.os.Bundle;  
import android.os.Environment;
import android.support.v4.app.Fragment;  
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.Button;  
import android.widget.TextView;
import android.widget.Toast;  
  
public class CategoryFragment extends Fragment{  
    Button myButton;  
    Button myButton2;
    Button myButton3;
    Button myButton4;
    Button myButton5;

    TextView myTextView;
	//DB
	String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/com.example.mylocator/databases" ;
	//String DB_PATH = "/data/data/com.example.mylocator/databases" ;
	String DB_NAME = "LocatorDB.db";
	//DB
    @Override  
    public View onCreateView(LayoutInflater inflater,    ViewGroup container,  
            Bundle savedInstanceState) {  
        View rootView = inflater.inflate(R.layout.category, container, false);//get the layout file  
      //get the button from rootView  
        myButton = (Button)rootView.findViewById(R.id.button1);//button for Music 
        myButton2 = (Button)rootView.findViewById(R.id.Button01);// button for Art
        myButton3 = (Button)rootView.findViewById(R.id.Button02);// button for parade
        myButton4 = (Button)rootView.findViewById(R.id.Button03);// button for festival
        myButton5 = (Button)rootView.findViewById(R.id.Button04);// button for family event
    	File f = new File(DB_PATH + DB_NAME);
    	
//    	if (!f.exists()) {
//    	Toast.makeText(getActivity(), "NO DB!!!!!!!", Toast.LENGTH_SHORT).show();
//    		eventDB();
//    	}   	



        //myTextView=(TextView) rootView.findViewById(R.id.mytextview);  
        //  
        myButton.setOnClickListener(new View.OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	//myTextView.setText("haha");
            	/*
            	Fragment newfragment= new ListFragment();
            	
            	FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
            	
            	//fragmentTransaction.replace(, newfragment);
            	fragmentTransaction.addToBackStack(null);
            	fragmentTransaction.commit();*/
            	Intent intent = new Intent();
            	intent.setClass(getActivity(),ListActivity.class);
            	startActivity(intent);
//                Toast.makeText(CategoryFragment.this.getActivity(), "button1 is click! (Music)", Toast.LENGTH_SHORT).show();  
            }  
        });  
        myButton2.setOnClickListener(new View.OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub
            	//myTextView.setText("hehe");
            	Intent intent = new Intent();
            	intent.setClass(getActivity(),ListActivity.class);
            	startActivity(intent);
//            	Toast.makeText(CategoryFragment.this.getActivity(), "button2 is click!(Art)", Toast.LENGTH_SHORT).show();  
            }  
        }); 
       myButton3.setOnClickListener(new View.OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub
            	//myTextView.setText("hehe");
            	Intent intent = new Intent();
            	intent.setClass(getActivity(),ListActivity.class);
            	startActivity(intent);
//            	Toast.makeText(CategoryFragment.this.getActivity(), "button3 is click!(Parade)", Toast.LENGTH_SHORT).show();  
            }  
        }); 
       myButton4.setOnClickListener(new View.OnClickListener() {  
           
           @Override  
           public void onClick(View v) {  
               // TODO Auto-generated method stub
           	//myTextView.setText("hehe");
           	Intent intent = new Intent();
           	intent.setClass(getActivity(),ListActivity.class);
           	startActivity(intent);
  //         	Toast.makeText(CategoryFragment.this.getActivity(), "button4 is click!(Festival)", Toast.LENGTH_SHORT).show();  
           }  
       }); 
       myButton5.setOnClickListener(new View.OnClickListener() {  
           
           @Override  
           public void onClick(View v) {  
               // TODO Auto-generated method stub
           	//myTextView.setText("hehe");
           	Intent intent = new Intent();
           	intent.setClass(getActivity(),ListActivity.class);
           	startActivity(intent);
  //         	Toast.makeText(CategoryFragment.this.getActivity(), "button5 is click!(Family Event)", Toast.LENGTH_SHORT).show();  
           }  
       });        
        return rootView;  
    }
	private void eventDB() {
		// TODO Auto-generated method stub
		
	}  
}  