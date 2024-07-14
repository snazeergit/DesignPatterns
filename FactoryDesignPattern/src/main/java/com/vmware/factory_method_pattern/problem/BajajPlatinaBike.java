package com.vmware.factory_method_pattern.problem;

public class BajajPlatinaBike implements BajajBike {
	private Double price;

	@Override
	public void painting() {
		System.out.println("BajajPlatinaBike.painting()");
	}

	@Override
	public void assembling() {
		System.out.println("BajajPlatinaBike.assembling()");
	}

	@Override
	public void engineTest() {
		System.out.println("BajajPlatinaBike.engineTest()");
	}

	@Override
	public void roadTest() {
		System.out.println("BajajPlatinaBike.roadTest()");
	}

	@Override
	public void drive() {
		System.out.println("BajajPlatinaBike.drive()");
	}

}
