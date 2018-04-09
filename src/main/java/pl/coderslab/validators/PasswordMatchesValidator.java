package pl.coderslab.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.coderslab.model.UserDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> { 

	  public void initialize(PasswordMatches constraintAnnotation) {       
	  }

	  public boolean isValid(Object obj, ConstraintValidatorContext context){   
	      UserDTO user = (UserDTO) obj;
	      return user.getPassword().equals(user.getMatchingPassword());    
	  }
	}