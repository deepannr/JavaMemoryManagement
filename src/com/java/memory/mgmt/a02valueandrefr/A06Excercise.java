package com.java.memory.mgmt.a02valueandrefr;

class A06Excercise {

	public static void main(String[] args) {
		A06Excercise main = new A06Excercise();
		main.start();
	}

	public void start() {
		String last = "Z";
		Container container = new Container(); // container.initial = A
		container.setInitial("C"); // container.initial = C
		another(container, last); // container.initial = C, last = Z
		System.out.println(container.getInitial()); // container.initial = B
	}

	public void another(Container initialHolder, String newInitial) {
		newInitial.toLowerCase(); // newInitial, last = Z. Here toLowerCase will convert to z but not set
									// newInitial, last to z. Because it is not newInitial =
									// newInitial.toLowerCase();
		initialHolder.setInitial("B"); // container.initial, initialHolder.initial = B
		Container initial2 = new Container(); // initial2.initial = A, container.initial, initialHolder.initial = B
		initialHolder = initial2; // initial2.initial, initialHolder.initial = A, container.initial = B. Here
									// initialHolder reference will be replaced to point to initial2 but not
									// container which remains same.
		System.out.println(initialHolder.getInitial()); // initialHolder.initial = A
		System.out.println(newInitial); // newInitial = Z
	}
}

class Container {
	private String initial = "A";

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}
}

/*
 * Output
 * A
 * Z
 * B
 */