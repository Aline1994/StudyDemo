package javaDemo;

import java.util.ArrayList;
import java.util.List;

public class OneceCount {
public static void main(String[] args) {
	int a[] = getOnce(new int[]{1,2,3,2,1});
}
	public static int [] getOnce(int [] zx) {
		int a[] = new int[zx.length];
		List list = new ArrayList();
		//{1,2,3,2,1}
		for(int i=zx.length;i>0;i--) { 
			for(int j=0;j<i;j++) {
				if(zx[i]==zx[j]) {
					list.add(zx[i]);
					list.add(zx[j]);
					System.out.println(zx[i]+"*********"+zx[j]);
				}
			}
		}
		return a;
	}
	
}
