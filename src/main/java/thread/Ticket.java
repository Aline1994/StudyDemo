package thread;
/**
 * ÂôÆ±ÎÊÌâ
 * @author zhuxiu
 *
 */
public class Ticket {
	public static void main(String[] args) {
		Tickets1 tk  = new Tickets1();
		Thread t = new Thread(tk);
		Thread t1 = new Thread(tk);
		Thread t2 = new Thread(tk);
		Thread t3 = new Thread(tk);
		/*Tickets t = new Tickets();
		Tickets t1 = new Tickets();
		Tickets t2 = new Tickets();
		Tickets t3 = new Tickets();*/
		t.start();
		t1.start();
		t2.start();
		t3.start();
	}
}
class Tickets extends Thread{
	private static int num = 100;
	
	public void run() {
		while(true) {
		if(num>0) {
			System.out.println(getName()+" "+num--);
		}
	}
	}
}
class Tickets1 implements Runnable{
	private int num = 100;
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(num>0) {
				System.out.println(Thread.currentThread().getName()+" --------"+num--);
			}
		}
	}
	
}