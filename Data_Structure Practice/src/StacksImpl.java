import java.io.*;
import java.util.*;

public class StacksImpl {
	public ArrayList<Integer> st = new ArrayList<>();
	int top = -1;
	
	public StacksImpl() {
		System.out.println("New Stack is created");
	}
	
	public void push(int a) {
		st.add(a);
		top = top+1;
		System.out.println("Inserted:"+a);
	}
	public int pop() {
		if(!isEmpty()) {
			int removed = st.remove(top);
			top = top-1;
			return removed;
		}
		else {
			System.out.println("Stack is empty");
			return 0;
		}
	}
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		return false;
	}
	
	public int getTop() {
		if(!isEmpty()) {
			return st.get(top);
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StacksImpl s = new StacksImpl();
		System.out.println(s.isEmpty());
		s.push(20);
		s.push(30);
		s.push(50);
		System.out.println(s.getTop());
		System.out.println(s.pop());
		System.out.println(s.getTop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.getTop());
	}

}
