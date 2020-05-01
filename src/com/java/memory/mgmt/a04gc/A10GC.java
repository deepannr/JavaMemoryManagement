package com.java.memory.mgmt.a04gc;

class A10GC {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		long available = runtime.freeMemory();
		System.out.println("Available Memory: " + available / (1024 * 1024) + "mb");

		for (int i = 0; i < 1000; ++i) {
			@SuppressWarnings("unused")
			Customer cust = new Customer("" + i);
		}

		available = runtime.freeMemory();
		System.out.println("Available Memory: " + available / (1024 * 1024) + "mb");

		/**
		 * When GC is called then it will call all the finalize method of the
		 * unreferenced object so the print statement is executed on the object.
		 */
		System.gc();

		available = runtime.freeMemory();
		System.out.println("Available Memory: " + available / (1024 * 1024) + "mb");
	}
}

class Customer {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	// Here customer object is passed as a reference of
	public Customer(Customer oldCustomer) {
		this.name = oldCustomer.getName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void finalize() {
		System.out.println("Object is GC.");
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}
}