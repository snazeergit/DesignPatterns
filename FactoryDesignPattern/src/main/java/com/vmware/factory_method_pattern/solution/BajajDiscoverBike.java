package com.vmware.factory_method_pattern.solution;

public class BajajDiscoverBike implements IBajajBike {

	private String milage;

	@Override
	public void drive() {
		System.out.println("BajajDiscoverBike.drive()");
	}

}
