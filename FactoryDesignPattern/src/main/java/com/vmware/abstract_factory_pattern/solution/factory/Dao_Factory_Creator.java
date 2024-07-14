package com.vmware.abstract_factory_pattern.solution.factory;

import com.vmware.abstract_factory_pattern.solution.enums.DbType;

public class Dao_Factory_Creator {

	public IDaoFactory build_DAO_Factory(String type) {
		IDaoFactory factory = null;
		if (type.equalsIgnoreCase(DbType.DB.name())) {
			factory = new DB_Factory();
		} else if (type.equalsIgnoreCase(DbType.EXCEL.name())) {
			factory = new Excel_Factory();
		}
		return factory;
	}

}