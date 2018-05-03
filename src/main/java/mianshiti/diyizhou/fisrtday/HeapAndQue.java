package mianshiti.diyizhou.fisrtday;

import java.util.Stack;
/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * @author zhuxiu
 *
 */
public class HeapAndQue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	public void push(int i) {
		stack1.push(new Integer(i));
	}
	
	public int pop() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop().intValue();
	}
}

