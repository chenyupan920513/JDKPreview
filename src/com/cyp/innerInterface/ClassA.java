package com.cyp.innerInterface;

public class ClassA {

	public static void main(String[] args) {
		A a = new A() {

			@Override
			public void sayHello() {
				System.out.println("i am a ");

			}
		};
		a.sayHello();
	}
	
}