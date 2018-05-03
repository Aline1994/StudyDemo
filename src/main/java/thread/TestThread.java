package thread;

public class TestThread  {
	public static void main(String[] args) {
		ThreadT tt = new ThreadT("zx111");
		ThreadT tt1 = new ThreadT("zx");
		tt.start();
		tt1.start();
		for(int i=0;i<50;i++) {
			System.out.println("main-------------"+i);
		}
	}
}

class ThreadT extends Thread{
	private String name;
	
	ThreadT(String name){
		super(name);
		this.name = name;
	}
	public void run() {
		for(int i=0;i<50;i++)
		System.out.println(ThreadT.currentThread().getName()+"-------------"+i);
	}
	
}