package com.vmware.breaks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.vmware.breaks.helper.Singleton5;

public class ClassLoader {

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		System.out.println("Using ApplicationClassLoader Sub-System");
		Singleton5 s1 = Singleton5.getInstance();
		System.out.println(s1.hashCode());
		System.out.println("----------");

		System.out.println("Using URLClassLoader Sub-System(Independent Readymade class loader)");
		/*
		 * Select the project and export-> General->Jar->browse to a location finish.
		 * enter browsed location preceded by file:
		 */
		URL url = new URL("file:/Users/armaansyed/git/DesignPatterns/Proj.jar");
		URL[] urlArray = new URL[] { url };

		/*
		 * Here URLClassLoader is an independent class loader not linked with JVM's class loader sub-systems.
		 * So, one object is created using ApplicationClassLoader of Class Loader Sub-System and other object is created
		 * using URLClassLoader which is a custom class loader sub-system.
		 */
		URLClassLoader loader = URLClassLoader.newInstance(urlArray, null);//not passing any Parent class loader so its null.
		Class<?> class1 = loader.loadClass("com.vmware.breaks.helper.Singleton5");
		Method method = class1.getDeclaredMethod("getInstance", new Class[] {});
		Object s2 = method.invoke(null);
		System.out.println(s2.hashCode());
		System.out.println("----------");

		System.out.println("Hashcode are different: Two Objects are different");
	}
}
