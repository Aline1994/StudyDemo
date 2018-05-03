package mianshiti.diyizhou.fisrtday;

import java.util.Stack;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
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

