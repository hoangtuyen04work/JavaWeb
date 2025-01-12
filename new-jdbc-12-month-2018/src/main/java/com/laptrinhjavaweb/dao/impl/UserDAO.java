package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO  {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM [user] AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append("  WHERE username  = ? AND password = ? AND status = ?");
		
		List<UserModel> users = null;
		users = query(sql.toString(), new UserMapper(), userName, password, status);
		if (users == null)
			return null;
		else
			return users.get(0);
	}


	
}