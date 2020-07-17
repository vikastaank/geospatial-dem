package com.vt.demo.core.dto;

import java.io.Serializable;
import java.util.List;

import com.vt.demo.core.ro.GeospatialCordinates;

public class GeospatialResponseDto implements Serializable {

	private static final long serialVersionUID = 3750573264211988876L;

	private List<GeospatialCordinates> sortedArray;

	public List<GeospatialCordinates> getSoretdArray() {
		return sortedArray;
	}

	public void setSoretdArray(List<GeospatialCordinates> soretdArray) {
		this.sortedArray = soretdArray;
	}

}
