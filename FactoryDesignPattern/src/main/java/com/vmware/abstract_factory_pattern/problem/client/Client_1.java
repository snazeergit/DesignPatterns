package com.vmware.abstract_factory_pattern.problem.client;

import com.vmware.abstract_factory_pattern.problem.factory.DB_Factory;
import com.vmware.abstract_factory_pattern.problem.factory.Excel_Factory;

public class Client_1 {

	public static void main(String[] args) {
		DB_Factory db_Factory = new DB_Factory();
		db_Factory.create_DB_Factory("Student").insertRecord();
		db_Factory.create_DB_Factory("COURSE").insertRecord();

		System.out.println("-------------------------");

		Excel_Factory excel_Factory = new Excel_Factory();
		excel_Factory.create_Excel_Factory("Student").insertRecord();
		excel_Factory.create_Excel_Factory("COurse").insertRecord();
	}

}

/*
 * Client has to create two factory objects to insert studentDao and CourseDAO records in two DB and Excel  
 */