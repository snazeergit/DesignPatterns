package com.vmware.factory_pattern.problem.client;

import com.vmware.factory_pattern.problem.BudgetCar;
import com.vmware.factory_pattern.problem.ICar;

public class ClientApp_2 {
	public static void main(String[] args) {
		System.out.println("ClientApp_2.main()");

		ICar budgetCar = new BudgetCar();
		budgetCar.assemble();
		budgetCar.roadTest();
		budgetCar.drive();
	}
}
