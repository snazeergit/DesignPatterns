package com.vmware.factory_pattern.solution.client;

import com.vmware.factory_pattern.problem.ICar;
import com.vmware.factory_pattern.solution.factory.CarFactory;

public class ClientApp_1 {
	public static void main(String[] args) {
		System.out.println("ClientApp_1.main()");

		ICar car = CarFactory.createCar("budget");
		car.assemble();
		car.roadTest();
		car.drive();
	}
}
