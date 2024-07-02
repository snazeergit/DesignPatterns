package com.vmware;

class Singleton {

	private static Singleton instance;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
}

public class BasicSingleton {

	public static void main(String[] args) {

		// Can not create object using new keyword as it has private constructor
		/*
		 * Singleton s1 = new Singleton();
		 * Singleton s2 = new Singleton();
		 */

		// Only way to create an object
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println("=======Basic Singleton===========");
		System.out.println("Hashcode of s1 object: " + s1.hashCode());
		System.out.println("Hashcode of s2 object: " + s2.hashCode());
		System.out.println("Different Objects have different Hashcodes");
	}
}
