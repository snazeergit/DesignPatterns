package com.vmware.abstract_factory_pattern.solution.dao;

public class DB_StudentDao implements IDao {

	@Override
	public void insertRecord() {
		System.out.println("DB_StudentDao.insertRecord()");
	}

}
