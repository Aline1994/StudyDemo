package Singleton;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class test{
	int a;
	int b;
	public test(int a,int b) {
		this.a = a;
		this.b = b;
	}
	public static void main(String[] args) {
		/*ConcurrentHashMap<Long, String>map = new ConcurrentHashMap<>();
		map.put(123l, "zhuxiu");
		for(Entry<Long, String>m:map.entrySet()) {
			System.out.println(m.getValue());
		}*/
		/*long l = 1L << 23 -1L;
		System.out.println(l);
		
		List list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		for(int i=0;i<list.size();i++) {
			if(i==5) {
				list.remove(i);
			}
			
			System.out.println(list.get(i));
		}*/
	/*	Map<Long, String> map2 = Collections.unmodifiableMap(map);
		map2.put(123l, "zx");
		for(Entry<Long, String>m:map.entrySet()) {
			System.out.println(m.getValue());
		}*/
		int t = new test(3,5) {
			public int add(int a,int b) {
				return a+b;
			}
		}.add(8,10);
		System.out.println(t);
		
		
	}
}