package com.java.memory.mgmt.a01stackandheap;

class A02LocalVariable {

	public static void main(String[] args) {
		int value = 5;
		calculateValue(value);
		System.out.println(value);
	}
	
	private static void calculateValue(int data) {
		data *= 3;
	}
}

/*
 * Here all are storing in the stack and they are primitive at line 8, the value remains 5 only.
 * 
 */
