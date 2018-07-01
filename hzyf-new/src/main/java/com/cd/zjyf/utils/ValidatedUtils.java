package com.cd.zjyf.utils;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.cd.zjyf.exception.ValidateException;

public class ValidatedUtils {
	public static void validate(BindingResult result) throws ValidateException {
		if (result.hasErrors()) {
			String msg = "";
			List<ObjectError> errorList = result.getAllErrors();
			FieldError fieldError = null;
			for (ObjectError error : errorList) {
				if (error instanceof FieldError)
					fieldError = (FieldError) error;
				msg = msg + fieldError.getDefaultMessage() + "  ";
			}
			throw new ValidateException(msg);
		}
	}

}
