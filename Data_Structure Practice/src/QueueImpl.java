import java.io.*;
import java.util.*;

public class QueueImpl {
	
	LLNode front = new LLNode();
	LLNode rear = new LLNode();
	
	public QueueImpl() {
		front.set_next_node(null);
		rear.set_next_node(null);
	}
	
	public void enqueue(int a) {
		LLNode l = new LLNode();
		l.set_data(a);
		l.set_next_node(null);
		if(isEmpty()) {
			front.set_next_node(l);
			rear.set_next_node(l);
		}
		else {
			rear.get_next_node().set_next_node(l);
			rear.set_next_node(l);
		}
	}
	
	public LLNode dequeue() {
		if(!isEmpty()) {
			LLNode r = front.get_next_node();
			front.set_next_node(r.get_next_node());
			r.set_next_node(null);
			return r;
		}
		return null;
	}
	
	public LLNode get_front() {
		return front;
	}
	
	public LLNode get_rear() {
		return rear;
	}
	
	public boolean isEmpty() {
		if(front.get_next_node() == null) {
			return true;
		}
		return false;
	}
	
	public int get_length(){
		int length = 0;
		LLNode temp = front;
		while(temp.get_next_node() != null) {
			temp = temp.get_next_node();
			length++;
		}
		return length;
	}
	public static void main(String args[]) {
		QueueImpl q= new QueueImpl();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(50);
		System.out.println(q.get_length());
		System.out.println(q.isEmpty());
		System.out.println(q.dequeue().get_data());
		System.out.println(q.get_rear().get_next_node().get_data());
		System.out.println(q.dequeue().get_data());
		System.out.println(q.dequeue().get_data());
		System.out.println(q.dequeue());
		System.out.println(q.isEmpty());
	}
}
