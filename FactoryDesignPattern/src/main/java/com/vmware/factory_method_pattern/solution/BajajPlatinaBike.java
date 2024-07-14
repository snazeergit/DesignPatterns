package com.vmware.factory_method_pattern.solution;

public class BajajPlatinaBike implements IBajajBike {
	private Double price;

	@Override
	public void drive() {
		System.out.println("BajajPlatinaBike.drive()");
	}

}
