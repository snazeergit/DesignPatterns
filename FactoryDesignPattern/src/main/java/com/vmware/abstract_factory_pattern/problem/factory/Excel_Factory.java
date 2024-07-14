package com.vmware.abstract_factory_pattern.problem.factory;

import com.vmware.abstract_factory_pattern.problem.dao.Excel_CourseDao;
import com.vmware.abstract_factory_pattern.problem.dao.Excel_StudentDao;
import com.vmware.abstract_factory_pattern.problem.dao.IDao;
import com.vmware.abstract_factory_pattern.problem.enums.ComponentType;

public class Excel_Factory {
	
	public IDao create_Excel_Factory(String componentType) {
		IDao dao = null;
		if (componentType.equalsIgnoreCase(ComponentType.STUDENT.name())) {
			dao = new Excel_StudentDao();
		} else if (componentType.equalsIgnoreCase(ComponentType.COURSE.name())) {
			dao = new Excel_CourseDao();

		}
		return dao;
	}
}
