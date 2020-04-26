package com.java.memory.mgmt.a01stackandheap;

/**
 * Stack stores primitive types only
 *
 */
class A01StackConcept {
	public static void main(String[] args) {
		int value = 7;
		value = calculate(value);
		System.out.println(value);
	}

	private static int calculate(int data) {
		int temp = data + 3;
		int newVal = temp * 2;
		return newVal;
	}
}
/*
 * Here at Stack when pointer comes to line 16, the order of stack will be
 * ------------ 
 * newVal = 20
 * temp = 10
 * data = 7
 * value = 7
 * args
 * ------------
 * 
 * After line 17, data, temp, newVal will be destroyed
 * and when comes to line 10,
 * ------------ 
 * value = 20
 * args
 * ------------
 * 
 * And after main execution complete all the variables in heap will be removed.
 * 
 */

