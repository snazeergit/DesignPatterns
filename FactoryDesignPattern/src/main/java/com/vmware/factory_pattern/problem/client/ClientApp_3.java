package com.vmware.factory_pattern.problem.client;

import com.vmware.factory_pattern.problem.ICar;
import com.vmware.factory_pattern.problem.LuxuryCar;

public class ClientApp_3 {
	public static void main(String[] args) {
		System.out.println("ClientApp_3.main()");

		ICar luxuryCar = new LuxuryCar();
		luxuryCar.assemble();
		luxuryCar.roadTest();
		luxuryCar.drive();
	}
}
