package com.vmware.complete;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

enum Singleton2 {
	// enum constants are public static final by default
	INSTANCE;

	private Singleton2() {

	}

	public static Singleton2 getInstance() {
		return INSTANCE;
	}

	/* Because of Eager instantiation of enum constants there will not be any Multithreading issues.
	* 
	* Enums have private constructors, and normally, Java prevents you from accessing them via reflection for security and integrity reasons.
	* For enums we can not create objects using reflection API even though they have private Constructors.
	*
	* The IllegalArgumentException: Cannot reflectively create enum objects error indicates that the Java runtime strictly prohibits the creation of enum instances via reflection. 
	* This is a security and integrity measure to ensure that enums, which are inherently singletons for each defined constant, cannot be violated by creating additional instances.
	*
	* clone() method is made as protected final in the internal default super class of our enum(any enum) that is java.lang.Enum<E>, 
	* so we can not override clone() in our enum.
	* 
	* Since every enum is already extending java.lang.Enum<E> class internally, it can not extend another class that is implementing Cloneable interface.
	* So our enum is not Cloneable  by default and we can not do cloning enum objects/constants. 
	* 
	* Every enum is Serializable by default i.e. we can do Serialization on enum constants/objects but when we attempt 
	* to do Deserialization then we get already available enum constant/object  i.e readResolve() functionality provided 
	* internally by overriding that method.
	* 
	* 
	*/
}

public class Enum_based_Singleton {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Singleton2 s1 = Singleton2.getInstance();
		System.out.println(s1.hashCode());

		Constructor<Singleton2> constructor = Singleton2.class.getDeclaredConstructor(String.class, int.class);
		constructor.setAccessible(true);
		/* 
		 * Attempting to use reflection to create another instance will not work 
		 * and throws Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
		 */
		Singleton2 s2 = constructor.newInstance("NEW_INSTANCE", 1);
		System.out.println(s2.hashCode());

	}

}
