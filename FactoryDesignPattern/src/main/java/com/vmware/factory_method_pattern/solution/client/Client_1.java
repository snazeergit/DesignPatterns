package com.vmware.factory_method_pattern.solution.client;

import com.vmware.factory_method_pattern.solution.IBajajBike;
import com.vmware.factory_method_pattern.solution.BikeType;
import com.vmware.factory_method_pattern.solution.factory.BajajBikeFactory;
import com.vmware.factory_method_pattern.solution.factory.ChennaiBajajFactory;

public class Client_1 {

	public static void main(String[] args) {
		BajajBikeFactory factory = new ChennaiBajajFactory();
		IBajajBike bike = factory.orderBike(BikeType.PULSER.name());
		bike.drive();
	}

}
