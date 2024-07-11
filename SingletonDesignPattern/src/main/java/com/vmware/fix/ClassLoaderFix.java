package com.vmware.fix;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import com.vmware.breaks.helper.Singleton5;

public class ClassLoaderFix {

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		System.out.println("Using ApplicationClassLoader Sub-System");
		Singleton5 s1 = Singleton5.getInstance();
		System.out.println(s1.hashCode() + " -> " + s1.getClass().getClassLoader());
		System.out.println("----------");

		System.out.println("Using URLClassLoader Sub-System(Independent Readymade class loader)");
		/*
		 * Select the project and export-> General->Jar->browse to a location finish.
		 * enter browsed location preceded by file:
		 */
		URL url = new URL("file:/Users/armaansyed/git/DesignPatterns/Proj.jar");
		URL[] urlArray = new URL[] { url };

		/*
		 * 2nd argument represents Parent Class Loader
		 * passing ApplicationClassLoader as Parent Class loader  to the URLClassLoader
		 * makes it not to load the same Singleton5 class again by URLClassLoader as its 
		 * already loader by Parent class loader which is ApplicationClassLoader
		 */
		URLClassLoader loader = URLClassLoader.newInstance(urlArray, s1.getClass().getClassLoader());
		Class<?> class1 = loader.loadClass("com.vmware.breaks.helper.Singleton5");
		Method method = class1.getDeclaredMethod("getInstance", new Class[] {});
		Object s2 = method.invoke(null);
		System.out.println(s2.hashCode() + " -> " + s2.getClass().getClassLoader());
		System.out.println("----------");
		System.out.println("Hashcode are same: Two Objects are same");

	}
}
