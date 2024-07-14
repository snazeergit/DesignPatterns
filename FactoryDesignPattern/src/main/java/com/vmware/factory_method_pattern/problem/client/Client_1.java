package com.vmware.factory_method_pattern.problem.client;

import com.vmware.factory_method_pattern.problem.BajajBike;
import com.vmware.factory_method_pattern.problem.factory.ChennaiBajajFactory;

public class Client_1 {

	public static void main(String[] args) {
		BajajBike bike = ChennaiBajajFactory.createBike("Pulser");
		bike.drive();
	}

}
