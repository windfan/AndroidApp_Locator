
package com.example.mylocator;

import android.content.Intent;
import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.Button;  
import android.widget.TextView;
import android.widget.Toast;  
  
public class MoreFragment extends Fragment{  
    Button myButton;  //for settings
    Button myButton2; //for Q&A
    Button myButton3; //for about us

    TextView myTextView;
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        View rootView = inflater.inflate(R.layout.more, container, false);//get the layout file  
        myButton = (Button)rootView.findViewById(R.id.button1);//button for setting
        myButton2 = (Button)rootView.findViewById(R.id.Button01);//button for Q&A
        myButton3 = (Button)rootView.findViewById(R.id.Button02);//button for about us
        
        myButton.setOnClickListener(new View.OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	Intent intent = new Intent();
            	intent.setClass(getActivity(),Settings.class); //need to change to setting page
            	startActivity(intent);
//                Toast.makeText(MoreFragment.this.getActivity(), "Settings is clicked!", Toast.LENGTH_SHORT).show();  
            }  
        });  
        myButton2.setOnClickListener(new View.OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	Intent intent = new Intent();
            	intent.setClass(getActivity(),Qanda.class); //need to change to setting page
            	startActivity(intent);
//                Toast.makeText(MoreFragment.this.getActivity(), "Q&A is clicked!", Toast.LENGTH_SHORT).show();  
            }  
        });  
        myButton3.setOnClickListener(new View.OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	Intent intent = new Intent();
            	intent.setClass(getActivity(),Aboutus.class); //need to change to setting page
            	startActivity(intent);
//                Toast.makeText(MoreFragment.this.getActivity(), "About us is clicked!", Toast.LENGTH_SHORT).show();  
            }  
        });  

       
          
        return rootView;  
    }  
}  