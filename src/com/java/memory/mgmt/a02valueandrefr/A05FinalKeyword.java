package com.java.memory.mgmt.a02valueandrefr;

/**
 * Here on final being used nothing guaranteed that all the variables will be final. Even by this getId method, value can be changed.
 * Final means the reference can't be changed but the value can be changed.
 * @author ab75812
 *
 */

public class A05FinalKeyword {

	public static void main(String[] args) {
		final Customers finCust = new Customers("DeclareFinal");
		
		final Customers cust;
		cust = new Customers("Final");
		
		/*
		* In finCust assigned while initialization.
		* In cust while initialization, instantiation is not performed. So final allows only one time
		* instatiation and while performing the second time, final will not allow to assign a new variable
		* in the heap.
		*
		*   finCust = new Customer("AnotherDeclare");
		*	cust = new Customer("Another");
		*/
		
		System.out.println(finCust.getName());
		
		finCust.setId("ID");
		finCust.setId("ID2");
		System.out.println(finCust.getId());
		System.out.println(finCust.getId());
		System.out.println(finCust.getId());
	}
}


class Customers {
	private String name;
	private String id;

	public Customers(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		String temp = this.id;
		this.id = this.id + "IDs";
		return temp;
	}	
}