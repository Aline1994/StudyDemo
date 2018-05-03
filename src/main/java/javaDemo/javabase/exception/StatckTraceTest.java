package javaDemo.javabase.exception;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatckTraceTest {
	private static final Logger myLogger = Logger.getLogger("");
	
	public static void main(String[] args) {
		Logger l = Logger.getLogger("com.java.zx");
		l.setLevel(Level.FINE);
		l.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		l.addHandler(handler);
		int a = factorial(4);
		System.out.println(a);
	}
	/**
	 * ½×³Ë
	 * n! = 1*2*3*.....*n
	 */
	public static int factorial(int n) {
		System.out.println("factorial("+n+")");
		Throwable t = new Throwable();
		StackTraceElement[] st = t.getStackTrace();
		for(StackTraceElement ss:st) {
			System.out.println(ss);
		}
		int r  ;
		if(n<=1) r=1;
		else r= n*factorial(n-1);
		return r;
	}
}
