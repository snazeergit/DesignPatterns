package com.vmware.ways.create;

public class Lazy_Initialization_with_Double_Checked_Locking_Singleton {

	private static volatile Lazy_Initialization_with_Double_Checked_Locking_Singleton instance;

	private Lazy_Initialization_with_Double_Checked_Locking_Singleton() {
	}

	public static Lazy_Initialization_with_Double_Checked_Locking_Singleton getInstance() {
		if (instance == null) {
			synchronized (Lazy_Initialization_with_Double_Checked_Locking_Singleton.class) {
				if (instance == null) {
					instance = new Lazy_Initialization_with_Double_Checked_Locking_Singleton();
				}
			}
		}
		return instance;
	}
}
