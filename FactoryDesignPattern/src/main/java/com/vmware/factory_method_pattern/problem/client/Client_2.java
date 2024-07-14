package com.vmware.factory_method_pattern.problem.client;

import com.vmware.factory_method_pattern.problem.BajajBike;
import com.vmware.factory_method_pattern.problem.factory.HyderabadBajajFactory;

public class Client_2 {

	public static void main(String[] args) {
		BajajBike bike = HyderabadBajajFactory.createBike("Pulser");
		bike.drive();
	}

}
