package com.vmware.semi.complete;

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

class Singleton implements Serializable, Cloneable {

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

public class Singleton_Fix_Reflection_Clone_Serialization {

	public static void main(String[] args) throws CloneNotSupportedException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			FileNotFoundException, IOException, ClassNotFoundException {

		// Singleton s1=new Singleton();
		Singleton s1 = Singleton.getInstance();

		// Trying to break using cloning
		Singleton s2 = (Singleton) s1.clone();

		// Trying to break using reflection
		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton s3 = constructor.newInstance();

		// Trying to break using Serialization
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("single.txt"));
		out.writeObject(s1);
		out.flush();
		out.close();

		ObjectInput in = new ObjectInputStream(new FileInputStream("Single.txt"));
		Singleton s4 = (Singleton) in.readObject();
		in.close();

	}
}
