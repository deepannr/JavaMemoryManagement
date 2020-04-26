package com.java.memory.mgmt.a01stackandheap;

import java.util.ArrayList;
import java.util.List;

public class A03ListInHeap {

	public static void main(String[] args) {
		List<String> main = new ArrayList<>();
		main.add("One");
		main.add("Two");
		System.out.println(main);
		listOperation(main);
		System.out.println(main);
	}

	private static void listOperation(List<String> method) {
		String value = method.get(1);
		System.out.println(value);
		method.add("Three");
		method.set(0, "Zero");
		System.out.println(method);
	}
}
