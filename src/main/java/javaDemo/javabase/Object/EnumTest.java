package javaDemo.javabase.Object;

import java.util.Scanner;

public class EnumTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("qingshuru");
		String input1 = in.next();
		
		Size size = Enum.valueOf(Size.class, input1);
		System.out.println(size);
		
		System.out.println(size.getAaa());
		
		
	}
}
