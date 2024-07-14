package com.vmware.abstract_factory_pattern.solution.factory;

import com.vmware.abstract_factory_pattern.solution.dao.IDao;

public interface IDaoFactory {
	public IDao create_Dao(String type);
}
