package com.vmware.factory_method_pattern.solution.client;

import com.vmware.factory_method_pattern.solution.IBajajBike;
import com.vmware.factory_method_pattern.solution.BikeType;
import com.vmware.factory_method_pattern.solution.factory.BajajBikeFactory;
import com.vmware.factory_method_pattern.solution.factory.BangloreBajajFactory;

public class Client_2 {

	public static void main(String[] args) {
		BajajBikeFactory factory = new BangloreBajajFactory();
		IBajajBike bike = factory.orderBike(BikeType.DISCOVER.name());
		bike.drive();
	}

}
