package com.java.memory.mgmt.a03escaperefr;

//import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class A07ListReference {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();
		records.addCustomer(new Customer("Dee"));
		records.addCustomer(new Customer("Pan"));

		System.out.println("---Print Map---");
		System.out.println(records.getCustomers());

		records.getCustomers().clear();

		// As getCustomers() returns a clone of records, even if the records clear then
		// it will not clear the clone.
		System.out.println("\n\n---Print getCustomers---");
		for (Customer customer : records.getCustomers().values()) {
			System.out.println(customer);
		}

		// But this is also an issue as iterator remove can do that.
		System.out.println("\n\n---Print using Iterator---");
		for (Customer customer : records) {
			System.out.println(customer);
		}
	}
}

/*
 * Here getCustomers seems like directly accessing the reference which is not
 * following encapsulation.
 */

//class CustomerRecords {
//	private Map<String, Customer> records;
//
//	public CustomerRecords() {
//		this.records = new HashMap<>();
//	}
//
//	public void addCustomer(Customer cust) {
//		this.records.put(cust.getName(), cust);
//	}
//
//	public Map<String, Customer> getCustomers() {
//		return this.records;
//	}
//}

class CustomerRecords implements Iterable<Customer> {
	private Map<String, Customer> records;

	public CustomerRecords() {
		this.records = new HashMap<>();
	}

	public void addCustomer(Customer cust) {
		this.records.put(cust.getName(), cust);
	}

	public Map<String, Customer> getCustomers() {
		return new HashMap<String, Customer>(this.records); // Here returns a new HashMap where on the constructor
															// passed its value. Even this is also not

		// return Collections.unmodifiableMap(this.records); // This is the perfect
		// solution. This creates a copy of original Map. Because if we try to add in
		// the runtime will get exception.

		//	Exception in thread "main" java.lang.UnsupportedOperationException
		//	at java.util.Collections$UnmodifiableMap.clear(Unknown Source)
		//	at com.java.memory.mgmt.a03escaperefr.A07ListReference.main(A07ListReference.java:18)

	}

	@Override
	public Iterator<Customer> iterator() {
		return records.values().iterator();
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

	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}
}