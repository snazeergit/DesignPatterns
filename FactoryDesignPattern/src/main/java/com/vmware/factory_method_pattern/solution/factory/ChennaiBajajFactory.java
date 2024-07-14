package com.vmware.factory_method_pattern.solution.factory;

public class ChennaiBajajFactory extends BajajBikeFactory {

	public ChennaiBajajFactory() {
		System.out.println("ChennaiBajajFactory.ChennaiBajajFactory()");
	}

	@Override
	public void painting() {
		System.out.println("ChennaiBajajFactory.painting()");
	}

	@Override
	public void assembling() {
		System.out.println("ChennaiBajajFactory.assembling()");
	}

	@Override
	public void engineTest() {
		System.out.println("ChennaiBajajFactory.engineTest()");
	}

	@Override
	public void roadTest() {
		System.out.println("ChennaiBajajFactory.roadTest()");
	}
}
