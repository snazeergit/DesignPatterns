package com.vmware.ways.create;

/*
 *Enums in java are inherently thread safe and guarantee a single instance. 
 *Enum Singletons are simple, concise and provide built-in thread safety.
 */
public enum Enum_Singleton {
	INSTANCE;

	public Enum_Singleton getInstance(String parm) {
		return Enum_Singleton.INSTANCE;
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
    age variable will not serialized

 */