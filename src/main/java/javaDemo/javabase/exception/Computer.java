package javaDemo.javabase.exception;

public class Computer {
	private int state;
	
	public void reset() throws LanpingException, MaoyanException {
		System.out.println("电脑重启");
		run();
	}

	public void run() throws LanpingException, MaoyanException {
		if(state==1) {
			throw new LanpingException("电脑蓝屏了");
		}
		if(state == 2) {
			throw new MaoyanException("电脑冒烟了");
		}
		System.out.println("电脑运行");
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