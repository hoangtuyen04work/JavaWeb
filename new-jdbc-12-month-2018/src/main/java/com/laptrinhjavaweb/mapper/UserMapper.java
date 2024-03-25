package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel users = new UserModel();
		try {
			users.setId(resultSet.getLong("id"));
			users.setUserName(resultSet.getString("username"));
			users.setFullName(resultSet.getString("fullname"));
			users.setPassword(resultSet.getString("password"));
			users.setStatus(resultSet.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				users.setRole(role);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return users;
		} catch (SQLException e) {
			return null;
		}
	}

}