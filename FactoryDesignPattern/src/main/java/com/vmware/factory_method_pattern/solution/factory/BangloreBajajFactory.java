package com.vmware.factory_method_pattern.solution.factory;

public class BangloreBajajFactory extends BajajBikeFactory {

	public BangloreBajajFactory() {
		System.out.println("BangloreBajajFactory.BangloreBajajFactory()");
	}

	@Override
	public void painting() {
		System.out.println("BangloreBajajFactory.painting()");
	}

	@Override
	public void assembling() {
		System.out.println("BangloreBajajFactory.assembling()");
	}

	@Override
	public void engineTest() {
		System.out.println("BangloreBajajFactory.engineTest()");
	}

	@Override
	public void roadTest() {
		System.out.println("BangloreBajajFactory.roadTest()");
	}
}
