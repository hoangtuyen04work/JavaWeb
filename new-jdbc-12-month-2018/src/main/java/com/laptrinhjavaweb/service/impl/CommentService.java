package com.laptrinhjavaweb.service.impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICommentDAO;
import com.laptrinhjavaweb.service.ICommentService;

public class CommentService implements ICommentService {
	@Inject
	ICommentDAO commentDao;

	@Override
	public void delete(Long idNew) {
		commentDao.delete(idNew);
	}

}
