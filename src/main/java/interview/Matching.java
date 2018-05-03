package interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * 主要考虑用栈操作，
 * 栈是先进后出的特性
 * 
 * 首先把第一个放入栈中。然后下一个匹配，如果和
 * @author zhuxiu
 *
 */
public class Matching {
	public static void main(String[] args) {
		String a = "(){}[]{{}}";
		boolean f = isMatch(a);
		System.out.println(f);
	}
	
	public static boolean isMatch(String a) {
		Stack<Character> s = new Stack<>();
		char [] b = a.toCharArray();
		if(a.length()%2!=0) {
			return false;
		}
		s.push(b[0]);
		for(int i=1;i<b.length;i++) {
			Character c1 ,c2;
			if(s.isEmpty()) {
				s.push(b[i]);
				c1=s.peek();
				c2=b[++i];
			}else {
				c1=s.peek();
				c2=b[i];
			}
			if(c1.toString().equals("(") && c2.toString().equals(")")
					||c1.toString().equals("[") && c2.toString().equals("]")
					||c1.toString().equals("{") && c2.toString().equals("}")
					) {
						s.pop();
					}else {
						s.push(c2);
					}	
		}
		if(s.isEmpty()) {
			return true;
		}
		return false;
	}
}
/*if(s.peek()=='{' && b[i+1]=='}'
|| s.peek()=='[' && b[i+1]==']'
|| s.peek()=='(' && b[i+1]==')') {
	s.pop();
	i++;
}else {
	s.push(b[i]);
}
}else {
if(s.peek()=='{' && b[i]=='}'
|| s.peek()=='[' && b[i]==']'
|| s.peek()=='(' && b[i]==')') {
	s.pop();
}else {
	s.push(b[i]);
}*/

