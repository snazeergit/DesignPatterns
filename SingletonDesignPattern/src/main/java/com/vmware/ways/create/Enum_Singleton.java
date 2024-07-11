package com.vmware.ways.create;

/*
 *Enums in java are inherently thread safe and guarantee a single instance. 
 *Enum Singletons are simple, concise and provide built-in thread safety.
 */
public enum Enum_Singleton {
	INSTANCE;

	public Enum_Singleton getInstance(String parm) {
		return INSTANCE;
	}

}

/* 
 * when serializing an enum, field variables are not getting serialized.
 * and all enum constants are of type public static final and can not be overridden.
 * 
 * public enum SingletonEnum {
    INSTANCE;
    int age;
   }
   
   Here attribute/field 'age' variable will not serialized.

 * An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).
 * 
 * Why And When To Use Enums?
 * Use enums when you have values that you know aren't going to change, like month days, days, colors, deck of cards, etc.
 * 
 * enum Level {
	  LOW,
	  MEDIUM,
	  HIGH
	}
 * 
 * You can access enum constants with the dot syntax:
 * Level myVar = Level.MEDIUM;
 */