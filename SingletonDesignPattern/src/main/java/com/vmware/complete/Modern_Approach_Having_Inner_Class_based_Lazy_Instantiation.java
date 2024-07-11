package com.vmware.complete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Singleton1 implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private static boolean isInstantiated = false;

	private static class SingletonInner {
		private static Singleton1 INSTANCE = new Singleton1();
	}

	// static factory
	public static Singleton1 getInstance() {
		// MultiThreading issues will not be there because of Single line logic below
		return SingletonInner.INSTANCE;
	}

	// Protection from Reflection
	private Singleton1() {
		if (isInstantiated)
			throw new RuntimeException("Instance is already created");
		else
			isInstantiated = true;
	}

	// protection from cloning
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Instance is already created");
	}

	// protection from Serialization
	protected Object readResolve() {
		return getInstance();
	}
}

public class Modern_Approach_Having_Inner_Class_based_Lazy_Instantiation implements Runnable {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException,
			IOException, ClassNotFoundException, CloneNotSupportedException {
		Singleton1 s1 = Singleton1.getInstance();
		System.out.println(s1.hashCode());

		// trying to break through MultiThreading approach
		Modern_Approach_Having_Inner_Class_based_Lazy_Instantiation runnable = new Modern_Approach_Having_Inner_Class_based_Lazy_Instantiation();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		t1.start();
		t2.start();
		t3.start();

		// trying to break through Reflection approach
		Constructor<Singleton1> constructor = Singleton1.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton1 s2 = constructor.newInstance();
		System.out.println(s2.hashCode());

		// trying to break through Serialization approach
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("singleton.txt"));
		outputStream.writeObject(s1);
		outputStream.flush();
		outputStream.close();

		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("singleton.txt"));
		Singleton1 s3 = (Singleton1) inputStream.readObject();
		inputStream.close();
		System.out.println(s3.hashCode());

		// trying to break through Cloning approach
		Singleton1 s4 = (Singleton1) s1.clone();
		System.out.println(s4.hashCode());
	}

	@Override
	public void run() {
		Singleton1 s5 = Singleton1.getInstance();
		System.out.println(s5.hashCode());

	}

}
