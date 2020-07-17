package com.vt.demo.core.ro;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GeospatialCordinates implements Serializable, Comparable<GeospatialCordinates> {

	private static final long serialVersionUID = 7533885397400382340L;

	private double latitude;

	private double longitude;

	@JsonIgnore
	private double distance;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "GeospatialCordinates [longitude=" + longitude + ", latitude=" + latitude + ", distance=" + distance
				+ "]";
	}

	@Override
	public int compareTo(GeospatialCordinates o) {
		if (this.distance == o.getDistance())
			return 0;
		else if (this.distance > o.getDistance())
			return 1;
		else
			return -1;
	}

}
