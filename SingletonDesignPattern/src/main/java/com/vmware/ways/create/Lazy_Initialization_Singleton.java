package com.vmware.ways.create;

public class Lazy_Initialization_Singleton {

	private static Lazy_Initialization_Singleton instance;

	private Lazy_Initialization_Singleton() {
	}

	public static Lazy_Initialization_Singleton getInstance() {
		if (instance == null) {
			instance = new Lazy_Initialization_Singleton();
		}
		return instance;
	}
}
