package com.vmware.abstract_factory_pattern.solution.factory;

import com.vmware.abstract_factory_pattern.solution.dao.DB_CourseDao;
import com.vmware.abstract_factory_pattern.solution.dao.DB_StudentDao;
import com.vmware.abstract_factory_pattern.solution.dao.IDao;
import com.vmware.abstract_factory_pattern.solution.enums.ComponentType;

public class DB_Factory implements IDaoFactory {

	public IDao create_Dao(String componentType) {
		IDao dao = null;
		if (componentType.equalsIgnoreCase(ComponentType.STUDENT.name())) {
			dao = new DB_StudentDao();
		} else if (componentType.equalsIgnoreCase(ComponentType.COURSE.name())) {
			dao = new DB_CourseDao();
		}
		return dao;
	}
}
