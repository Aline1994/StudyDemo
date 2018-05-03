package javaDemo.javabase.innerclass;

public class Outer {
	private String name = "aaa";
	class Inner{
		public void method1() {
			System.out.println(name);
		}
	}
	public void function() {
		new Inner().method1();
	}
	public static void main(String[] args) {
		Outer ou = new Outer();
		ou.function();
	}
}

