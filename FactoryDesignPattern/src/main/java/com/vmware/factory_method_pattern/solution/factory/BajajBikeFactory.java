package com.vmware.factory_method_pattern.solution.factory;

import com.vmware.factory_method_pattern.solution.IBajajBike;
import com.vmware.factory_method_pattern.solution.BajajDiscoverBike;
import com.vmware.factory_method_pattern.solution.BajajPlatinaBike;
import com.vmware.factory_method_pattern.solution.BajajPulserBike;
import com.vmware.factory_method_pattern.solution.BikeType;

public abstract class BajajBikeFactory {

	public abstract void painting();

	public abstract void assembling();

	public abstract void engineTest();

	public abstract void roadTest();

	public IBajajBike createBike(String bikeType) {
		IBajajBike bike = null;
		if (bikeType.equalsIgnoreCase(BikeType.PULSER.name())) {
			bike = new BajajPulserBike();
		} else if (bikeType.equalsIgnoreCase(BikeType.DISCOVER.name())) {
			bike = new BajajDiscoverBike();
		} else if (bikeType.equalsIgnoreCase(BikeType.PLATINA.name())) {
			bike = new BajajPlatinaBike();
		} else {
			throw new IllegalArgumentException("Invalid Bike type");
		}
		return bike;
	}

	public IBajajBike orderBike(String bikeType) {

		painting();
		assembling();
		engineTest();
		roadTest();

		return createBike(bikeType);
	}

}
