package javaDemo.javabase.interfacece;

import java.util.Arrays;
import java.util.Comparator;

public class TestInterface implements Comparator<String> {
	public static void main(String[] args) {
		Integer [] a = {3,5,7,8,9,4};
		String [] b = {"a","b","e","d"};
		Arrays.sort(b,new TestInterface());
		for(String bb:b) {
			System.out.print(bb);
		}
		/*Arrays.sort(a,new TestInterface());
		for(int in:a) {
			System.out.print(in);
		}*/
	}

	public int compare(String o1, String o2) {
		if(o1==null||o2==null) {
			return -1;
		}
		if(o1.length()>o2.length()) {
			return 1;
		}
		if(o1.compareTo(o2)>0) {
			return 1;
		}
		if(o1.compareTo(o2)<0) {
			return -1;
		}
		if(o1.compareTo(o2)==0) {
			return 0;
		}
		return 0 ;
	}
	
	

}
