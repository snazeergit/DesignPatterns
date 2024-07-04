package com.vmware.ways.create;

/*
 * The idea is to use a static inner class to hold the Singleton instance.
 * The instance is created only when the getInstance() method of the outer class is called.
*/
public class Bill_Pugh_Solution_Singleton {

	private Bill_Pugh_Solution_Singleton() {
	}

	private static class LazyHolder {
		private static final Bill_Pugh_Solution_Singleton INSTANCE = new Bill_Pugh_Solution_Singleton();
	}

	public static Bill_Pugh_Solution_Singleton getInstance() {
		return LazyHolder.INSTANCE;

	}
}
