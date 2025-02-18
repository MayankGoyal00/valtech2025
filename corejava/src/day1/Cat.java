package day1;

public class Cat implements Animal {

		@Override
		public void makeSound() {
			System.out.println("meow...");

		}

		@Override
		public void eat() {
			System.out.println("eat rat...");
		}

		@Override
		public void sleep() {
			System.out.println("light snore..");
		}

}
