package com.vt.demo.core.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = GeospatialCordinatesCustomValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface GeospatialCordinatesConstraint {
	String message() default "Invalid request data";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}