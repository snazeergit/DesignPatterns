package com.vmware.factory_pattern.solution;

public class BudgetCar implements ICar {

	private String fuelEconomy;
	private Double price;

	public BudgetCar() {
		System.out.println("BudgetCar.BudgetCar()");
	}

	@Override
	public void assemble() {
		System.out.println("BudgetCar.assemble()");

	}

	@Override
	public void roadTest() {
		System.out.println("BudgetCar.roadTest()");
	}

	@Override
	public void drive() {
		System.out.println("BudgetCar.drive()");
	}

}
