package mianshiti.diyizhou.fisrtday;

public class HeapTest{
	public static void main(String args[]) {
		HeapAndQue ha = new HeapAndQue();
		ha.push(10);
		ha.push(4);
		ha.push(6);
		int a  = ha.pop();
		System.out.println(a);
								
	}
}