package com.vmware.factory_pattern.solution.factory;

import com.vmware.factory_pattern.problem.BudgetCar;
import com.vmware.factory_pattern.problem.ICar;
import com.vmware.factory_pattern.problem.LuxuryCar;
import com.vmware.factory_pattern.problem.SportsCar;
import com.vmware.factory_pattern.solution.CarType;

public class CarFactory {

	public static ICar createCar(String carType) {
		ICar car = null;

		/*
		 * CarType.BUDGET.name() returns the name of the enum constant BUDGET in this case.
		 */

		if (carType.equalsIgnoreCase(CarType.BUDGET.name()))
			car = new BudgetCar();
		else if (carType.equalsIgnoreCase(CarType.LUXURY.name()))
			car = new LuxuryCar();
		else if (carType.equalsIgnoreCase(CarType.SPORTS.name()))
			car = new SportsCar();
		else
			throw new IllegalArgumentException("Invalid Car type");

		return car;

	}
}
