package com.vt.demo.core.ro;

import java.io.Serializable;
import java.util.List;

import com.vt.demo.core.validator.GeospatialCordinatesConstraint;

public class Geospatial implements Serializable {

	private static final long serialVersionUID = 6876785218494545907L;

	// @GeospatialCordinatesConstraint(message = "failing longitude/latitude valid range")
	private GeospatialCordinates referencePoint;

	@GeospatialCordinatesConstraint
	private List<GeospatialCordinates> array;

	public GeospatialCordinates getReferencePoint() {
		return referencePoint;
	}

	public void setReferencePoint(GeospatialCordinates referencePoint) {
		this.referencePoint = referencePoint;
	}

	public List<GeospatialCordinates> getArray() {
		return array;
	}

	public void setArray(List<GeospatialCordinates> array) {
		this.array = array;
	}

}
