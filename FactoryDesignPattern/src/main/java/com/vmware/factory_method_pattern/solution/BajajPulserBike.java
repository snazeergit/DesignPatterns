package com.vmware.factory_method_pattern.solution;

public class BajajPulserBike implements IBajajBike {

	private String power;

	@Override
	public void drive() {
		System.out.println("BajajPulserBike.drive()");
	}

}
