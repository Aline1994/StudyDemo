package javaDemo.javabase.exception;

public class RunTime {
	public static void main(String[] args) throws FuException {
		int a = div(10,-3);
		System.out.println(a);
	}

	private static int div(int i, int j) throws FuException {
		int c = i/j;
		if(j<0) {
			throw new FuException("fushuchuxiianle ", j);
		}
		return c;
	}
}
class FuException extends Exception{
	int c;
	public FuException(String msg,int c) {
		super(msg);
		this.c = c;
	}
	public int getC() {
		return c;
	}
}
