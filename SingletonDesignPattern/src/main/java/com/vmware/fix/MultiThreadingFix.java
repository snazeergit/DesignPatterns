package com.vmware.fix;

class Singleton3 {
	private static volatile Singleton3 INSTANCE = null;

	private Singleton3() {
	}

	public static Singleton3 getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton3.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton3();
				}
			}
		}
		return INSTANCE;
	}
}

public class MultiThreadingFix implements Runnable {

	public static void main(String[] args) {
		MultiThreadingFix mt = new MultiThreadingFix();
		Thread t1 = new Thread(mt);
		Thread t2 = new Thread(mt);
		Thread t3 = new Thread(mt);
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {
		Singleton3 instance = Singleton3.getInstance();
		System.out.println(instance.hashCode());
	}
}
