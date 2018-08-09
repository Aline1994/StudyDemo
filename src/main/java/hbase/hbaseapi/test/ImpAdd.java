package hbase.hbaseapi.test;

public class ImpAdd extends Addabs {
	public int add(int a,int b) {
		return a+b;
	}
	public static void main(String[] args) {
		ImpAdd imp = new ImpAdd() {
			public int add(int a,int b) {
				return a-b;
			}
		};
		int c = imp.add(8, 4);
		System.out.println(c);
	}
}
