package com.vmware.breaks;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Singleton {
	private static Singleton INSTANCE = null;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton();
		}
		return INSTANCE;
	}
}

public class Reflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = null;

		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		s2 = constructor.newInstance();

		System.out.println("=======Breaking Singleton using: Reflection===========");
		System.out.println("Hashcode of s1 object: " + s1.hashCode());
		System.out.println("Hashcode of s2 object: " + s2.hashCode());
		System.out.println("Different Objects have different Hashcodes");

	}

}
