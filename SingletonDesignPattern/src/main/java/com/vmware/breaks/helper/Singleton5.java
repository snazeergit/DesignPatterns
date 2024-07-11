package com.vmware.breaks.helper;

public class Singleton5 {
	private static volatile Singleton5 INSTANCE = null;

	// prevent breaking using Reflection
	private Singleton5() {
		if (INSTANCE != null) {
			throw new RuntimeException("Instance already available");
		}
	}

	// prevent breaking using MultiThreading | double check locking
	public static Singleton5 getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton5.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton5();
				}
			}
		}
		return INSTANCE;
	}

	// prevent breaking using cloning
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Instance is already available");
	}

//prevent breaking using Deserialization
	public Object readResolve() {
		return getInstance();
	}
}