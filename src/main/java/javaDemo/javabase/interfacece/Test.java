package javaDemo.javabase.interfacece;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Test {
	public static void main(String[] args) {
		ActionListener al = new TimePrinter();
		Timer t = new Timer(1000, al);
		t.start();
		JOptionPane.showMessageDialog(null, "quit program?");
		System.exit(0);
	}
}
