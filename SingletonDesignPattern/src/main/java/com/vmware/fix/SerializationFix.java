package com.vmware.fix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

class Singleton1 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static Singleton1 INSTANCE = null;

	private Singleton1() {

	}

	private Object readResolve() throws ObjectStreamException {
		return getInstance();

	}

	public static Singleton1 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton1();
		}
		return INSTANCE;
	}
}

public class SerializationFix {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = null;

		ObjectOutput objOutput = new ObjectOutputStream(new FileOutputStream("simple.txt"));
		objOutput.writeObject(s1);
		objOutput.close();

		ObjectInput objInput = new ObjectInputStream(new FileInputStream("simple.txt"));
		s2 = (Singleton1) objInput.readObject();
		objInput.close();

		System.out.println("=======Prevent Singleton class Breaking by: Serialization===========");
		System.out.println("Hashcode of s1 object: " + s1.hashCode());
		System.out.println("Hashcode of s2 object: " + s2.hashCode());
		System.out.println("Different Objects have different Hashcodes");
	}

}
