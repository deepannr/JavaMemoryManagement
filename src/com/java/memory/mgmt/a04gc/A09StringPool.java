package com.java.memory.mgmt.a04gc;

public class A09StringPool {

	public static void main(String[] args) {

		/*
		 * Stack is very efficient as if the "}" is there then the local variable will
		 * be popped out and removed from the stack.
		 * 
		 * So if we want to make the object long live, we are sharing the objects across
		 * the methods.
		 * 
		 * Here when two is created, JVM make sure that one and two are having the same
		 * reference. This is called internalized string.
		 * 
		 * == will check only the reference but .equals will check the value.
		 */
		String one = "hello";
		String two = "hello";

		if (one == two) {
			System.out.println("Objects reference are same");
		} else {
			System.out.println("Objects reference are different");
		}

		/**
		 * Here as new is used, java not able to reuse the string created for three to
		 * four
		 */
		String three = new String("string");
		String four = "string";

		if (three == four) {
			System.out.println("Objects reference are same");
		} else {
			System.out.println("Objects reference are different");
		}

		/**
		 * Every class maintains a String pool internally, initially it will be empty.
		 * If intern is invoked, if the pool has already object in the heap then the
		 * reference will be returned else the object will be added to the pool. so that
		 * if the next string is declared then it can be taken from that reference.
		 */
		String five = new String("another").intern();
		String six = "another";

		if (five == six) {
			System.out.println("Objects reference are same");
		} else {
			System.out.println("Objects reference are different");
		}
	}
}
