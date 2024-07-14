package com.vmware.factory_pattern.problem.client;

import com.vmware.factory_pattern.problem.ICar;
import com.vmware.factory_pattern.problem.SportsCar;

public class ClientApp_1 {
	public static void main(String[] args) {
		System.out.println("ClientApp_1.main()");

		ICar sportsCar = new SportsCar();
		sportsCar.assemble();
		sportsCar.roadTest();
		sportsCar.drive();
	}
}
