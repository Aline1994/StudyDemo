package javaDemo.javabase.innerclass;

public class Test {
	public static Inter function() {
		Inter in = new Inter() {
			@Override
			public void method() {
				System.out.println("hello,world");
			}
		};
		return in;
	}
	public static void main(String[] args) {
		Test.function().method();;
	}
}
