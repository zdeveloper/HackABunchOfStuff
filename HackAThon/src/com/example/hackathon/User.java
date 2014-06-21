package com.example.hackathon;

import com.parse.ParseGeoPoint;

public class User {

	public User(String username, String password, String email, String city,
			ParseGeoPoint parseGeoPoint, String channel, String precinct, String type,
			String string) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.city = city;
		this.location = parseGeoPoint;
		this.channel = channel;
		this.precinct = precinct;
		this.type = type;
		this.badges = string;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public ParseGeoPoint getLocation() {
		return location;
	}
	public void setLocation(ParseGeoPoint location) {
		this.location = location;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getPrecinct() {
		return precinct;
	}
	public void setPrecinct(String precinct) {
		this.precinct = precinct;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBadges() {
		return badges;
	}
	public void setBadges(String badges) {
		this.badges = badges;
	}
	String username;
	String password;
	String email;
	String city;
	ParseGeoPoint location; 
	String channel;
	String precinct;
	String type;
	String badges;
	
	
	
}
