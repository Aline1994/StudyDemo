package javaDemo.javabase.interfacece;



import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Lambdabidao {
	public static void main(String[] args) {
		String [] exam = {"aaaa","b","ccc","ddd","ggg","aaa","vvvvvvvvvvs"};
		System.out.println(Arrays.toString(exam));
		Arrays.sort(exam);
		System.out.println(Arrays.toString(exam));
		
		Arrays.sort(exam,(first,second)-> first.length()-second.length());
		
		System.out.println(Arrays.toString(exam));
		
		Timer t = new Timer(1000,event-> 
				System.out.println("the time is "+new Date())
				);
		t.start();
		JOptionPane.showMessageDialog(null, "quit program?");
		System.exit(0);
	}
	
	
}
