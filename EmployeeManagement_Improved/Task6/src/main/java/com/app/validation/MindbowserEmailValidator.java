package com.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MindbowserEmailValidator implements ConstraintValidator<MindbowserEmail, String> {

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		

		if (email == null || email.isEmpty()) {
            return true; // let @NotBlank handle this
        }

        return email.endsWith("@mindbowser.com");
	}
	
}
