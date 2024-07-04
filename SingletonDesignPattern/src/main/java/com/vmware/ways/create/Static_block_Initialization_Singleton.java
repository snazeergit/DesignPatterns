package com.vmware.ways.create;

public class Static_block_Initialization_Singleton {

	private static Static_block_Initialization_Singleton instance;

	private Static_block_Initialization_Singleton() {
	}

	static {
		instance = new Static_block_Initialization_Singleton();
	}

	public static Static_block_Initialization_Singleton getInstance() {
		return instance;
	}
}
