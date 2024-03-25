package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {

	List<NewModel> findByCategoryId(Long categoryId);

	Long save(NewModel newModel);

	NewModel findOne(Long id);

	void update(NewModel updateNew);



	List<NewModel> findAll(Pageble pageble);

	void delete(Long id);

	int getTotalItem();

	
}