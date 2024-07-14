package com.vmware.abstract_factory_pattern.solution.dao;

public class Excel_StudentDao implements IDao {

	@Override
	public void insertRecord() {
		System.out.println("ExcelStudentDao.insertRecord()");
	}

}
