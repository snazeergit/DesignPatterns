package com.vmware.complete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * This class fix for preventing Singleton breakage using MutliThreading, Cloning, Serialization and Reflection API. 
 */

/*
 * It is recommended to add SerialVersionUID to every Serializable class so we will not get
 * InvalidClassException during Deserialization process even though the class structure is 
 * changed.
 */

class Singleton implements Serializable, Cloneable {
	// To avoid InvalidClassException even though the class structure is changed at
	// the time of Deserialization
	private static final long serialVersionUID = 1L;

	// volatile to make the threads to have access to latest value of INSTANCE
	private static volatile Singleton INSTANCE = null;

	// Preventing Reflection to Break singleton
	private Singleton() {
		if (INSTANCE != null) {
			throw new RuntimeException("Instance is already available");
		}
	}

	// Double check locking
	public static Singleton getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}

	// Preventing cloning to break Singleton
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Instance is already available");
	}

	// Preventing Serialization to break Singleton
	protected Object readResolve() {
		return getInstance();
	}
}

public class Legacy_Approach_static_factory_double_checked_locking implements Runnable {

	public static void main(String[] args) throws CloneNotSupportedException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			FileNotFoundException, IOException, ClassNotFoundException {

		// Singleton s1=new Singleton();
		Singleton s1 = Singleton.getInstance();
		System.out.println(s1.hashCode());

		// Trying to break using cloning
		Singleton s2 = (Singleton) s1.clone(); // comment this line and execute
		System.out.println(s2.hashCode());

		// Trying to break using reflection
		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton s3 = constructor.newInstance(); // comment this line and execute
		System.out.println(s3.hashCode());

		// Trying to break using Serialization
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("single.txt"));
		out.writeObject(s1);
		out.flush();
		out.close();

		ObjectInput in = new ObjectInputStream(new FileInputStream("Single.txt"));
		Singleton s4 = (Singleton) in.readObject();
		in.close();
		System.out.println(s4.hashCode());

		Legacy_Approach_static_factory_double_checked_locking runnable = new Legacy_Approach_static_factory_double_checked_locking();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {
		Singleton s5 = Singleton.getInstance();
		System.out.println(s5.hashCode());

	}
}
