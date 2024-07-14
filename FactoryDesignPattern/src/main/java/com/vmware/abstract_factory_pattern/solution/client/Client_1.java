package com.vmware.abstract_factory_pattern.solution.client;

import com.vmware.abstract_factory_pattern.solution.dao.IDao;
import com.vmware.abstract_factory_pattern.solution.factory.Dao_Factory_Creator;
import com.vmware.abstract_factory_pattern.solution.factory.IDaoFactory;

public class Client_1 {

	public static void main(String[] args) {
		Dao_Factory_Creator dao_Factory = new Dao_Factory_Creator();
		
		// using abstract dao_factory object create two dao factory objects
		IDaoFactory db_Dao_factory = dao_Factory.build_DAO_Factory("DB");
		IDao studentDbDao = db_Dao_factory.create_Dao("Student");
		IDao courseDbDao = db_Dao_factory.create_Dao("Course");
		studentDbDao.insertRecord();
		courseDbDao.insertRecord();

		IDaoFactory excel_Dao_factory = dao_Factory.build_DAO_Factory("Excel");
		IDao courseExcelDao = excel_Dao_factory.create_Dao("Course");
		IDao studentExcelDao = excel_Dao_factory.create_Dao("Student");
		courseExcelDao.insertRecord();
		studentExcelDao.insertRecord();
	}

}

/*
 * Client has to create two factory objects to insert studentDao and CourseDAO records in two DB and Excel  
 */