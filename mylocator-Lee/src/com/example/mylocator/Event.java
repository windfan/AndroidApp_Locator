package com.example.mylocator;

public class Event {
	private String name;
	private String location;
	private String time;
	
	public void setName(String name){
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	public Event(String name ,String location,String time) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.location=location;
		this.time=time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	 
}