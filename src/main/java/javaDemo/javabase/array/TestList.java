package javaDemo.javabase.array;

import java.util.ArrayList;
import java.util.List;

class Apple{
	String color;
	public Apple(String color) {
		this.color = color;
	}
}
public class TestList {
	public static void main(String[] args) {
		Apple a = new Apple("red");
		Apple a1 = new Apple("green");
		List<Apple>l = new ArrayList<>();
		l.add(a);l.add(a1);
		System.out.println(l.get(0)==a);
		System.out.println(l.get(1)==a1);
		
	}
}
