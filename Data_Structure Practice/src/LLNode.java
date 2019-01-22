
public class LLNode {
	int data;
	LLNode l = null;
	
	public int get_data() {
		return data;
	}
	
	public LLNode get_next_node() {
		return l;
	}
	
	public void set_data(int data) {
		this.data = data;
	}
	
	public void set_next_node(LLNode l) {
		this.l = l;
	}
	
}
