package com.example.mylocator;

 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.util.EncodingUtils;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.util.Log;
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;  
import android.widget.Toast;
  
public class ScheduleFragment extends Fragment {  
	
	  private ListView listView;
	  private TextView[] testview;
	  private RelativeLayout[] layout;
	  private View rootView;
	  private ArrayList<Event> myche;
	  DBAdapter myDB;
	  public String addr;
	  public String lat_reading;
	  public String lng_reading;
	  private int currentPage=0;
	  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
      rootView = inflater.inflate(R.layout.schedule, container, false);//get the layout file  
       
      myche=readFileByLines("/data/data/com.example.mylocator/files/schedule.txt");
      testview=new TextView[15];
      layout=new RelativeLayout[5];
      testview[0]=(TextView)rootView.findViewById(R.id.schedule1);
      testview[1]=(TextView)rootView.findViewById(R.id.schedule2);
      testview[2]=(TextView)rootView.findViewById(R.id.schedule3);
      testview[3]=(TextView)rootView.findViewById(R.id.schedule4);
      testview[4]=(TextView)rootView.findViewById(R.id.schedule5);
      testview[5]=(TextView)rootView.findViewById(R.id.schedule6);
      testview[6]=(TextView)rootView.findViewById(R.id.schedule7);
      testview[7]=(TextView)rootView.findViewById(R.id.schedule8);
      testview[8]=(TextView)rootView.findViewById(R.id.schedule9);
      testview[9]=(TextView)rootView.findViewById(R.id.schedule10);
      testview[10]=(TextView)rootView.findViewById(R.id.schedule11);
      testview[11]=(TextView)rootView.findViewById(R.id.schedule12);
      testview[12]=(TextView)rootView.findViewById(R.id.schedule13);
      testview[13]=(TextView)rootView.findViewById(R.id.schedule14);
      testview[14]=(TextView)rootView.findViewById(R.id.schedule15);
      layout[0]=(RelativeLayout)rootView.findViewById(R.id.event_frame1);
      layout[1]=(RelativeLayout)rootView.findViewById(R.id.event_frame2);
      layout[2]=(RelativeLayout)rootView.findViewById(R.id.event_frame3);
      layout[3]=(RelativeLayout)rootView.findViewById(R.id.event_frame4);
      layout[4]=(RelativeLayout)rootView.findViewById(R.id.event_frame5);
       
      getData();
       
      layout[0].setOnClickListener(new View.OnClickListener() {  
           
        @Override  
        public void onClick(View v) {  
           // TODO Auto-generated method stub  
       	  Intent intent = new Intent();
       	  intent.setClass(getActivity(),EventDetail.class);
       	  //grab info from database
         	String time_in_schedile= "12:25 PM";
         	String date_in_schedule= "Dec 16";
         	String Addr_in_schedule= "630 Atlantic Ave, Brooklyn, NY 11217";
         	double lat_in_schedule= 40.682990;
         	double lng_in_schedule= -73.974780;
         	
         	
         	Bundle bundle= new Bundle();
         	TextView name = (TextView) rootView.findViewById(R.id.schedule1);
         	TextView region = (TextView) rootView.findViewById(R.id.schedule2);

         	bundle.putString("key_name", name.getText().toString());
         	bundle.putString("key_region", region.getText().toString());
         	bundle.putString("key_time", time_in_schedile);
         	bundle.putString("key_date", date_in_schedule);
         	bundle.putString("key_addr", Addr_in_schedule);
         	bundle.putString("key_lat", Double.valueOf(lat_in_schedule).toString());
         	bundle.putString("key_lng", Double.valueOf(lng_in_schedule).toString());


          intent.putExtras(bundle);
          startActivity(intent);
        }  
      }); 
 
      layout[1].setOnClickListener(new View.OnClickListener() {  
          
        @Override  
        public void onClick(View v) {  
            // TODO Auto-generated method stub  
        	Intent intent = new Intent();
        	intent.setClass(getActivity(),EventDetail.class);
        	Bundle bundle= new Bundle();
        	TextView name = (TextView) rootView.findViewById(R.id.schedule4);
        	TextView region = (TextView) rootView.findViewById(R.id.schedule5);
        	bundle.putString("key_name", name.getText().toString());
        	bundle.putString("key_region", region.getText().toString());
        	intent.putExtras(bundle);
        	startActivity(intent);
        }  
      }); 

      layout[2].setOnClickListener(new View.OnClickListener() {  
          
        @Override  
        public void onClick(View v) {  
          // TODO Auto-generated method stub  
        	Intent intent = new Intent();
        	intent.setClass(getActivity(),EventDetail.class);
        	Bundle bundle= new Bundle();
        	TextView name = (TextView) rootView.findViewById(R.id.schedule7);
        	TextView region = (TextView) rootView.findViewById(R.id.schedule8);
        	bundle.putString("key_name", name.getText().toString());
        	bundle.putString("key_region", region.getText().toString());
        	intent.putExtras(bundle);
        	startActivity(intent);
        }  
      }); 
      layout[3].setOnClickListener(new View.OnClickListener() {  
          
        @Override  
        public void onClick(View v) {  
          // TODO Auto-generated method stub  
        	Intent intent = new Intent();
        	intent.setClass(getActivity(),EventDetail.class);
        	Bundle bundle= new Bundle();
        	TextView name = (TextView) rootView.findViewById(R.id.schedule10);
        	TextView region = (TextView) rootView.findViewById(R.id.schedule11);
        	bundle.putString("key_name", name.getText().toString());
        	bundle.putString("key_region", region.getText().toString());
        	intent.putExtras(bundle);
        	startActivity(intent);
        }  
      }); 
      layout[4].setOnClickListener(new View.OnClickListener() {  
          
        @Override  
        public void onClick(View v) {  
          // TODO Auto-generated method stub  
        	Intent intent = new Intent();
        	intent.setClass(getActivity(),EventDetail.class);
        	Bundle bundle= new Bundle();
        	TextView name = (TextView) rootView.findViewById(R.id.schedule13);
        	TextView region = (TextView) rootView.findViewById(R.id.schedule14);
        	bundle.putString("key_name", name.getText().toString());
        	bundle.putString("key_region", region.getText().toString());
        	intent.putExtras(bundle);
        	startActivity(intent);
        }  
      }); 
      return rootView;  
    }  
  
	  public void getData(){
		 
		  int i=currentPage*5;
		  int j=0;
		  int item=0;
		  while(i<myche.size()){
			 
			  testview[j].setText(myche.get(i).getName());
			  testview[j+1].setText(myche.get(i).getLocation());
			  testview[j+2].setText(myche.get(i).getTime());
			  i+=1;
			  j+=3;
			  item+=1;
		  }

		  for(int k=5-item, l=1;k>0;k--,l++)
		  {
			  layout[5-l].setVisibility(View.INVISIBLE);
			  Log.i("invisible","in"+k);
		  }
	  }
    
	
	  public void outPutFile() throws IOException{}

	  public  ArrayList<Event> readFileByLines(String fileName) {
      File file = new File(fileName);
      BufferedReader reader = null;
      ArrayList<Event> events= new ArrayList<Event>();
      try {
          System.out.println("one line per time");
          reader = new BufferedReader(new FileReader(file));
          String tempString = null;
          String str1=null;
          String str2=null;
          String str3=null;
          int line = 0;
          Event e;
          while ((tempString = reader.readLine()) != null) {
              System.out.println("line " + line + ": " + tempString);
              if(line%3==0) str1=tempString;
              if(line%3==1) str2=tempString;
              if(line%3==2) {
                str3=tempString;
                events.add(new Event(str1,str2,str3));
              }
              line++;
          }
          reader.close();
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if (reader != null) {
              try {
                  reader.close();
              } catch (IOException e1) {
              }
          }
      }
      return events;
  }
   
}  