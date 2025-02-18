package day1;

public class Dog implements Animal {

	@Override
	public void makeSound() {
		System.out.println("bark...");

	}

	@Override
	public void eat() {
		System.out.println("eat padigree...");
	}

	@Override
	public void sleep() {
		System.out.println("snore..");

	}

}
