package com.java.memory.mgmt.a05tunevm;

import java.util.ArrayList;
import java.util.List;

public class A15HeapSize {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		while (true) {
			Customer customer = new Customer("Dee");
			customers.add(customer);
			/**
			 * For every 100 item, 10 items will be eligible for GC.
			 */

			if (customers.size() >= 100) {
				for (int i = 0; i < 10; i++) {
					customers.remove(0);
				}
			}
		}
	}
}

class Customer {

	private int id;
	private String name;

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return id + " : " + name;
	}

	public Customer(String name) {
		super();
		this.name = name;
	}
}