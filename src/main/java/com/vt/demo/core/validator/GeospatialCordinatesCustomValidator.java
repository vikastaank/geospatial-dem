package com.vt.demo.core.validator;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vt.demo.core.ro.GeospatialCordinates;

public class GeospatialCordinatesCustomValidator
		implements ConstraintValidator<GeospatialCordinatesConstraint, List<GeospatialCordinates>> {

	@Override
	public boolean isValid(List<GeospatialCordinates> list, ConstraintValidatorContext context) {
//		for (GeospatialCordinates gc : list) {
//			if (gc.getLatitude() < -90 || gc.getLatitude() > 90)
//				return false;
//		}
//		return true;
		AtomicBoolean isValid = new AtomicBoolean(true);
		list.forEach(v -> {
			if (!(v.getLatitude() >= -90 && v.getLatitude() <= 90)
					|| !(v.getLongitude() >= -180 && v.getLongitude() <= 180))
				isValid.set(false);
		});
		return isValid.get();
	}

}
