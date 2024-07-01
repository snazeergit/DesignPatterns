package com.vmware.fix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Singleton {
	private static Singleton INSTANCE = null;

	private Singleton() {
		if (INSTANCE != null) {
			throw new RuntimeException("Instance already exists");
		}
	}

	public static Singleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton();
		}
		return INSTANCE;
	}
}

public class ReflectionFix {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = null;

		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		// throws InvocationTargetException caused by RuntimeException: Instance already exists
		s2 = constructor.newInstance();

		System.out.println("=======Prevent Singleton class Breaking by: Reflection===========");
		System.out.println("Hashcode of s1 object: " + s1.hashCode());
		System.out.println("Hashcode of s2 object: " + s2.hashCode());
		System.out.println("Different Objects have different Hashcodes");

	}

}
