package javaDemo.javabase.exception;

public class Computer {
	private int state;
	
	public void reset() throws LanpingException, MaoyanException {
		System.out.println("��������");
		run();
	}

	public void run() throws LanpingException, MaoyanException {
		if(state==1) {
			throw new LanpingException("����������");
		}
		if(state == 2) {
			throw new MaoyanException("����ð����");
		}
		System.out.println("��������");
	}
}
class LanpingException extends Exception{
	LanpingException(String msg){
		super(msg);
	}
}
class MaoyanException extends Exception{
	MaoyanException(String msg){
		super(msg);
	}
}