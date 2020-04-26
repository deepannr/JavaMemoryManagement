package com.java.memory.mgmt.a02valueandrefr;

class A04PassValueOnObject {

	public static void main(String[] args) {
		Customer localCust = new Customer("Initial");
		System.out.println("localCust: " + localCust.getName());
		setCustomer(localCust);
		System.out.println("localCust: " + localCust.getName());
	}

	private static void setCustomer(Customer methCust) {
		System.out.println("methCust: " + methCust.getName());
		methCust.setName("Changed");
		System.out.println("methCust: " + methCust.getName());
	}

}

class Customer {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

/*
* At Line 12, both the variables localCust, methCust in stack point to the same reference Customer in Heap.
* 		customer name will point to created string reference Initial.
* Line 13, on setting different name, as both localCust, methCust point to same Customer, localCust name also get changed.
* 		As String is immutable customer name will point the newly created string reference Changed.
*/
