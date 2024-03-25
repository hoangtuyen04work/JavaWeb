package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CommentModel;

public class CommentMapper implements RowMapper<CommentModel> {

	@Override
	public CommentModel mapRow(ResultSet resultSet) {
		CommentModel comment = new CommentModel();
		try {
			comment.setId(resultSet.getLong("id"));
			comment.setContent(resultSet.getString("content"));
			comment.setCreatedBy(resultSet.getString("createdby"));
			comment.setCreatedDate(resultSet.getTimestamp("createddate"));
			comment.setModifiedBy(resultSet.getString("modifiedby"));
			comment.setNewId(resultSet.getLong("newsid"));
			comment.setUserId(resultSet.getLong("userid"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				comment.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getString("modifiedby") != null) {
				comment.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return comment;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
