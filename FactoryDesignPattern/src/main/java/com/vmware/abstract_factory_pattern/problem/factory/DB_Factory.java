package com.vmware.abstract_factory_pattern.problem.factory;

import com.vmware.abstract_factory_pattern.problem.dao.DB_CourseDao;
import com.vmware.abstract_factory_pattern.problem.dao.DB_StudentDao;
import com.vmware.abstract_factory_pattern.problem.dao.IDao;
import com.vmware.abstract_factory_pattern.problem.enums.ComponentType;

public class DB_Factory {

	public IDao create_DB_Factory(String componentType) {
		IDao dao = null;
		if (componentType.equalsIgnoreCase(ComponentType.STUDENT.name())) {
			dao = new DB_StudentDao();
		} else if (componentType.equalsIgnoreCase(ComponentType.COURSE.name())) {
			dao = new DB_CourseDao();
		}

		return dao;
	}

}
