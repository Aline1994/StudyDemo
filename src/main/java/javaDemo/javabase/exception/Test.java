package javaDemo.javabase.exception;

public class Test {
	public static void main(String[] args) {
		Computer c = new Computer();
		try {
			c.run();
			return ;
		} catch (LanpingException | MaoyanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("反正最后执行我");
		}
	}
}
