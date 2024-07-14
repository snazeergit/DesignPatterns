package com.vmware.factory_pattern.solution.client;

import com.vmware.factory_pattern.problem.ICar;
import com.vmware.factory_pattern.solution.factory.CarFactory;

public class ClientApp_3 {
	public static void main(String[] args) {
		System.out.println("ClientApp_3.main()");

		ICar car = CarFactory.createCar("luxury");
		car.assemble();
		car.roadTest();
		car.drive();
	}
}
