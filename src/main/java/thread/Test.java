package thread;


public class Test{
	public static void main(String[] args) {
		Test1 dl = new Test1(true);
		Thread t = new Thread(dl);
		Thread t1 = new Thread(new Test1(false));
		t.start();
		t1.start();
	}
	
}








class Test1 implements Runnable{
	private boolean  boo;
	public Test1(Boolean boo) {
		this.boo=boo;
	}
	public void run() {
		if(boo) {
			synchronized (Mylocak.a) {
				System.out.println("a");
				synchronized (Mylocak.b) {
					System.out.println("b");
				}
			}
		}else {
			synchronized (Mylocak.b) {
				System.out.println("b");
				synchronized (Mylocak.a) {
					System.out.println("a");
				}
			}
		}
		
	}

}
class Mylocak {
	public static Object a = new Object();
	public static Object b = new Object();
}

