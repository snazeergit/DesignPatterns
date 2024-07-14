package com.vmware.abstract_factory_pattern.solution.dao;

public class Excel_CourseDao implements IDao {

	@Override
	public void insertRecord() {
		System.out.println("Excel_CourseDao.insertRecord()");
	}

}
