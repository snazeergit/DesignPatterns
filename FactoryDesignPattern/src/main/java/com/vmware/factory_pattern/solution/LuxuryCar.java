package com.vmware.factory_pattern.solution;

public class LuxuryCar implements ICar {

	private String bootSpace;
	private String security;

	public LuxuryCar() {
		System.out.println("LuxuryCar.LuxuryCar()");
	}

	@Override
	public void assemble() {
		System.out.println("LuxuryCar.assemble()");
	}

	@Override
	public void roadTest() {
		System.out.println("LuxuryCar.roadTest()");
	}

	@Override
	public void drive() {
		System.out.println("LuxuryCar.drive()");
	}

}
