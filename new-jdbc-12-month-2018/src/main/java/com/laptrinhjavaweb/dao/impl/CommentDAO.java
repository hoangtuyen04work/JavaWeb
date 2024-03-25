package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.ICommentDAO;
import com.laptrinhjavaweb.model.CommentModel;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO {

	@Override
	public void delete(Long idNew) {
		String sql = "DELETE FROM comment WHERE newsid = ?";
		update(sql, idNew);
	}

}
