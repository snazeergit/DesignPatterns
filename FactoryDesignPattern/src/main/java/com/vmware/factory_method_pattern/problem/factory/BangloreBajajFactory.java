package com.vmware.factory_method_pattern.problem.factory;

import com.vmware.factory_method_pattern.problem.BajajBike;
import com.vmware.factory_method_pattern.problem.BajajDiscoverBike;
import com.vmware.factory_method_pattern.problem.BajajPlatinaBike;
import com.vmware.factory_method_pattern.problem.BajajPulserBike;
import com.vmware.factory_method_pattern.problem.BikeType;

public class BangloreBajajFactory {

	public static BajajBike createBike(String bikeType) {
		System.out.println("BangloreBajajFactory.createBike()");
		BajajBike bike = null;
		if (bikeType.equalsIgnoreCase(BikeType.PULSER.name())) {
			bike = new BajajPulserBike();
		} else if (bikeType.equalsIgnoreCase(BikeType.DISCOVER.name())) {
			bike = new BajajDiscoverBike();
		} else if (bikeType.equalsIgnoreCase(BikeType.PLATINA.name())) {
			bike = new BajajPlatinaBike();
		} else {
			throw new IllegalArgumentException("Invalid Bike type");
		}
		bike.assembling();
		bike.engineTest();

		return bike;
	}
}
