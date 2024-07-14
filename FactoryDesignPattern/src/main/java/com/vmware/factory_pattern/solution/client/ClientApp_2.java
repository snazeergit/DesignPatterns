package com.vmware.factory_pattern.solution.client;

import com.vmware.factory_pattern.problem.ICar;
import com.vmware.factory_pattern.solution.factory.CarFactory;

public class ClientApp_2 {
	public static void main(String[] args) {
		System.out.println("ClientApp_2.main()");

		ICar budgetCar = CarFactory.createCar("budget");
		budgetCar.assemble();
		budgetCar.roadTest();
		budgetCar.drive();
	}
}