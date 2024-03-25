package com.laptrinhjavaweb.service.impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.dao.impl.UserDAO;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService {
	@Inject
	private IUserDAO userDAO;


	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
