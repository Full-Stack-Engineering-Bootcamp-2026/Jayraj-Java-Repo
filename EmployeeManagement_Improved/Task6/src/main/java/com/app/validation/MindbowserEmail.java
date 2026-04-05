package com.app.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented  
@Constraint(validatedBy = MindbowserEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MindbowserEmail {
	
	String message() default "Email must be from mindbowser.com";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
