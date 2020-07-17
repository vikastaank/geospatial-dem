package com.vt.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vt.demo.core.basic.Response;
import com.vt.demo.core.basic.ResponseConstants;
import com.vt.demo.core.dto.GeospatialResponseDto;
import com.vt.demo.core.exception.GeospatialBusinessException;
import com.vt.demo.core.exception.ValidationException;
import com.vt.demo.core.ro.Geospatial;
import com.vt.demo.core.ro.GeospatialCordinates;
import com.vt.demo.core.validator.GeospatialCordinatesConstraint;
import com.vt.demo.util.GeospatialUtil;

@RestController
@RequestMapping("/api/geospatial")
public class GeoSpatialController {

	@PostMapping
	public Response<GeospatialResponseDto> getGeospatialDataSorted(
			@Valid @GeospatialCordinatesConstraint @RequestBody Geospatial data, BindingResult bindingResult)
			throws Exception {
		if (bindingResult.hasErrors()) {
			throw new ValidationException(ResponseConstants.CONSTRAINT_VIOLATION_MSG,
					"invalid request data, please give valid value for latitue/longitude : Latitude must be >= -90 and <= +90 | Longitude must be >= -180 and <= +180");
		}
		try {
			GeospatialResponseDto dto = new GeospatialResponseDto();
			GeospatialCordinates refPoint = data.getReferencePoint();
			List<GeospatialCordinates> distCalculatedList = new ArrayList<>();
			data.getArray().stream().forEach(c -> {
				c.setDistance(GeospatialUtil.getDistanceFromLatLonInKm(refPoint.getLatitude(), refPoint.getLongitude(),
						c.getLatitude(), c.getLongitude()));
				distCalculatedList.add(c);
			});
			Collections.sort(distCalculatedList);
			dto.setSoretdArray(distCalculatedList);
			return new Response<GeospatialResponseDto>(dto, ResponseConstants.SUCCESS_MSG,
					ResponseConstants.HTTP_STATUS_SUCCESS_CODE,
					"List of cordinates sorted according to the given reference point.");
		} catch (Exception e) {
			throw new GeospatialBusinessException("Some exception occurred - " + e.getMessage());
		}
	}

	@ExceptionHandler({ GeospatialBusinessException.class })
	public ResponseEntity<Object> handleNotFoundException(GeospatialBusinessException ex) {
		Response<Object> response = new Response<>();
		if (ex.getCode() != null)
			response.setStatus(ex.getCode());
		else
			response.setStatus(ResponseConstants.FAILURE_MSG);

		if (ex.getHttpStatus() != 0)
			response.setStatusCode(ex.getHttpStatus());
		else
			response.setStatusCode(ResponseConstants.HTTP_STATUS_INTERNAL_SERVER_ERROR_CODE);

		if (ex.getMessage() != null)
			response.setStatusMsg(ex.getMessage());
		else
			response.setStatusMsg(ResponseConstants.INTERNAL_SERVER_ERROR_MSG);

		ex.printStackTrace();
		return new ResponseEntity<Object>(response, new HttpHeaders(), HttpStatus.valueOf(response.getStatusCode()));
	}

}
