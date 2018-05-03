package javaDemo.javabase.exception;

public class Techer {
	private String name;
	private Computer com;
	
	public Techer(String name) {
		this.name = name;
		com = new Computer();
	}
	public void speaking() throws LanpingException, MaoyanException {
			com.run();	
		System.out.println("½²¿Î");
	}
	public static void main(String[] args) throws LanpingException, MaoyanException {
		Techer t = new Techer("kaka");
		try {
			t.speaking();
		} catch (LanpingException e) {
			t.com.reset();
		}catch(MaoyanException e) {
			
		}
	}
}
