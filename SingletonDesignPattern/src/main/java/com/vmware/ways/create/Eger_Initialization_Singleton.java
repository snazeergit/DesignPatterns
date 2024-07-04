package com.vmware.ways.create;

/*
 * The below approach is effective but comes with a drawback.
 * An instance is created regardless of whether it is needed during runtime.
 */

public class Eger_Initialization_Singleton {

	private static volatile Eger_Initialization_Singleton instance = new Eger_Initialization_Singleton();

	private Eger_Initialization_Singleton() {
	}

	public static Eger_Initialization_Singleton getInstance() {
		return instance;
	}
}
