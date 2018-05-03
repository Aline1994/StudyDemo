package javaDemo.javabase.Object;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Reflected {
	public static void main(String[] args) {
		int [] a = new int[100];
		a = Arrays.copyOf(a, 2*a.length);
	}
	public static Object[] badCopyOf(Object []a,int newLength) {
		Object newArray[] = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length,newLength));
		return newArray;
	}
	
	public static Object goodCopyOf(Object a,int newLength) {
		Class cl = a.getClass();
		if(!cl.isArray())
			return null;
		Class ct = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(ct, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length,newLength));
		return newArray;
	}
}
