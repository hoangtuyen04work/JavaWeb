package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.CommentModel;

public interface ICommentDAO extends GenericDAO<CommentModel> {
	void delete(Long idNew);
}
