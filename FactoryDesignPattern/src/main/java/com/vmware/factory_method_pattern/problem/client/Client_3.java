package com.vmware.factory_method_pattern.problem.client;

import com.vmware.factory_method_pattern.problem.BajajBike;
import com.vmware.factory_method_pattern.problem.factory.BangloreBajajFactory;

public class Client_3 {

	public static void main(String[] args) {
		BajajBike bike = BangloreBajajFactory.createBike("Pulser");
		bike.drive();
	}

}
