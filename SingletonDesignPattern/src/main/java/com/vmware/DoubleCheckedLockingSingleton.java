package com.vmware;

class Singleton1 {

	// to make recent value of INSTANCE is available to all threads
	private static volatile Singleton1 INSTANCE = null;

	private Singleton1() {

	}

	public static Singleton1 getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton1();
				}
			}
		}
		return INSTANCE;
	}
}

public class DoubleCheckedLockingSingleton {

	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();

		System.out.println("=======Double Checked Locking Singleton===========");
		System.out.println("Hashcode of s1 object: " + s1.hashCode());
		System.out.println("Hashcode of s2 object: " + s2.hashCode());
		System.out.println("Different Objects have different Hashcodes");
	}

}
