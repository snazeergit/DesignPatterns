package com.vmware.breaks;

class Singleton2 implements Cloneable {
	private static Singleton2 INSTANCE = null;

	private Singleton2() {

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public static Singleton2 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton2();
		}
		return INSTANCE;
	}
}

public class Cloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton2 s1 = Singleton2.getInstance();
		Singleton2 s2 = (Singleton2) s1.clone();

		System.out.println("=======Breaking Singleton using: Cloning===========");
		System.out.println("Hashcode of s1 object: " + s1.hashCode());
		System.out.println("Hashcode of s2 object: " + s2.hashCode());
		System.out.println("Different Objects have different Hashcodes");
	}

}
