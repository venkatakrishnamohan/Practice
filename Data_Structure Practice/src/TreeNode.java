
public class TreeNode {
	int data;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public void set_data(int data) {
		this.data = data;
	}
	
	public int get_data() {
		return this.data;
	}
	
	public TreeNode get_left_child() {
		return this.left;
	}
	
	public void set_left_child(TreeNode left) {
		this.left = left;
	}
	
	public TreeNode get_right_child() {
		return this.right;
	}
	
	public void set_right_child(TreeNode right) {
		this.right = right;
	}
	
}
