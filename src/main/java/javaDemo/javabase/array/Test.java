package javaDemo.javabase.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.hsqldb.lib.Set;

public class Test {
	public static void main(String[] args) {
		/*Set2Map<String,Integer>scores = 
				new Set2Map<String,Integer>();
		scores.Put("����", 465);
		scores.Put("��ѧ", 345);
		scores.Put("Ӣ��", 140);
		scores.Put("��ѧ", 123);
		scores.Put("����", 80);
		System.out.println(scores);
		System.out.println(scores.size());
		scores.removeEntry("����");
		System.out.println(scores);
		scores.clear();
		System.out.println(scores);
		HashSet set =  new HashSet();
		set.add(1);
		set.add(3);
		Iterator obj = set.iterator();
		while(obj.hasNext()) {
			System.out.println(obj.next());
		}
		*/
		int num = Runtime.getRuntime().availableProcessors();
		System.out.println(num);
	}
}
