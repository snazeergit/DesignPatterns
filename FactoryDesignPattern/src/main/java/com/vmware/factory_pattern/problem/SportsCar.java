package com.vmware.factory_pattern.problem;

public class SportsCar implements ICar {

	private String speed;
	private String pickup;

	public SportsCar() {
		System.out.println("SportsCar.SportsCar()");
	}

	@Override
	public void assemble() {
		System.out.println("SportsCar.assemble()");
	}

	@Override
	public void roadTest() {
		System.out.println("SportsCar.roadTest()");
	}

	@Override
	public void drive() {
		System.out.println("SportsCar.drive()");
	}

}
