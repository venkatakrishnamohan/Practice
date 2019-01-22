import java.util.ArrayList;

public class MinHeap {
	ArrayList<Integer> a = new ArrayList<>();
	int i=0;
	
	public void insert(int data) {
	
			a.add(data);
			int ind = a.size()-1;
			while(ind >0 && a.get(get_parent(ind)) >= data) {
				int temp = a.get(get_parent(ind));
				a.set(get_parent(ind), data);
				a.set(ind, temp);
				ind = get_parent(ind);
		}
	}
	public int delete_min() {
		if(!isEmpty()) {
		int r = get_min();
		a.set(0, a.get(a.size()-1));
		a.remove(a.size()-1);
		int ind = 0;
		while(true) {
			if(get_left(ind) < a.size() && a.get(ind) > a.get(get_left(ind))) {
				int temp = a.get(get_left(ind));
				a.set(get_left(ind), a.get(ind));
				a.set(ind, temp);
				ind = get_left(ind);
			}
			else if(get_right(ind) < a.size() && a.get(ind) > a.get(get_right(ind))) {
				int temp = a.get(get_right(ind));
				a.set(get_right(ind), a.get(ind));
				a.set(ind, temp);
				ind = get_right(ind);
			}
			else {
				break;
			}
		}
		return r;
		}
		else {
			return -1;
		}
	}
	
	public int get_min() {
		if(!isEmpty()) {
			return a.get(0);
		}
		else {
			return -1;
		}
	}
	
	public boolean isEmpty() {
		if(a.size() == 0) {
			return true;
		}
		return false;
	}
	
	public int get_parent(int i) {
		return (i+1)/2 - 1;
	}
	
	public int get_left(int i) {
		return 2*i+1;
	}
	
	public int get_right(int i) {
		return 2*i+2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap mh = new MinHeap();
		System.out.println(mh.isEmpty());
		mh.insert(10);
		mh.insert(2);
		mh.insert(30);
		mh.insert(1);
		System.out.println(mh.get_min());
		System.out.println(mh.delete_min());
		System.out.println(mh.get_min());
		System.out.println(mh.delete_min());
		System.out.println(mh.get_min());
		System.out.println(mh.delete_min());
		System.out.println(mh.get_min());
		System.out.println(mh.delete_min());
		System.out.println(mh.get_min());
		System.out.println(mh.delete_min());
	}

}
