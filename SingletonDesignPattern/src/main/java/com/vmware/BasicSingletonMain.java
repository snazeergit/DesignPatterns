package com.vmware;

class SingletonBaseVersion {

	private static SingletonBaseVersion instance;

	private SingletonBaseVersion() {

	}

	public static SingletonBaseVersion getInstance() {
		if (instance == null)
			instance = new SingletonBaseVersion();
		return instance;
	}
}

public class BasicSingletonMain {

	public static void main(String[] args) {

		// Can not create object using new keyword as it has private constructor
		/*
		 * SingletonBaseVersion s1 = new SingletonBaseVersion();
		 * SingletonBaseVersion s2 = new SingletonBaseVersion();
		 */

		// Only way to create an object
		SingletonBaseVersion s1 = SingletonBaseVersion.getInstance();
		SingletonBaseVersion s2 = SingletonBaseVersion.getInstance();

		System.out.println("Hashcode of s1 object: " + s1.hashCode());
		System.out.println("Hashcode of s2 object: " + s2.hashCode());
		System.out.println("Different Objects have different Hashcodes");
	}
}
