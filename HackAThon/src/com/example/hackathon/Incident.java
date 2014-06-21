package com.example.hackathon;

public class Incident {

	private double longitude;
	private double latitude;
	private String feedId;
	private String googleHangout;
	private String type;
	private String description;

	public Incident(String type, String description, double d, double e,
			String feedId, String googleHangout) {
		this.type = type;
		this.description = description;
		this.longitude = d;
		this.latitude = e;
		this.feedId = feedId;
		this.googleHangout = googleHangout;
	}

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

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}
