package com.vmware.abstract_factory_pattern.solution.dao;

public class DB_CourseDao implements IDao {

	@Override
	public void insertRecord() {
		System.out.println("DB_CourseDao.insertRecord()");
	}

}
