package com.example.hackathon;

public class Incident {

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFeedId() {
		return feedId;
	}
	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}
	public String getGoogleHangout() {
		return googleHangout;
	}
	public void setGoogleHangout(String googleHangout) {
		this.googleHangout = googleHangout;
	}
	String type;
	String description;
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public Incident(String type, String description, float longitude,
			float latitude, String feedId, String googleHangout) {
		super();
		this.type = type;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
		this.feedId = feedId;
		this.googleHangout = googleHangout;
	}
	float longitude;
	float latitude;
	String feedId;
	String googleHangout;
	
	
}
