package pl.coderslab.service;

import pl.coderslab.Entity.User;
import pl.coderslab.model.UserDTO;
import pl.coderslab.validators.EmailExistsException;

public interface IUserService {
	User registerNewUserAccount(UserDTO accountDto) 
		      throws EmailExistsException;
}