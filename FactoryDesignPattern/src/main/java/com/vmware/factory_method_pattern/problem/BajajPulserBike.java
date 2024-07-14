package com.vmware.factory_method_pattern.problem;

public class BajajPulserBike implements BajajBike {

	@Override
	public void painting() {
		System.out.println("BajajPulserBike.painting()");
	}

	@Override
	public void assembling() {
		System.out.println("BajajPulserBike.assembling()");
	}

	@Override
	public void engineTest() {
		System.out.println("BajajPulserBike.engineTest()");
	}

	@Override
	public void roadTest() {
		System.out.println("BajajPulserBike.roadTest()");
	}

	@Override
	public void drive() {
		System.out.println("BajajPulserBike.drive()");
	}

}
