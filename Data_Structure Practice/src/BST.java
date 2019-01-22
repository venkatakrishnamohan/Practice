import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BST {
	
	TreeNode root = null;
	
	public void insert(int data) {
		root = insert_node(root,data);
	}
	
	public TreeNode insert_node(TreeNode root, int data) {
		if(root == null) {
			TreeNode t = new TreeNode(data);
			root = t;
		}
		else if(data <= root.data) {
			root.left = insert_node(root.left,data);
		}
		else {
			root.right = insert_node(root.right,data);
		}
		return root;
	}
	
	public void delete(int data) {
		root = delete_node(root,data);
	}
	
	public TreeNode delete_node(TreeNode root,int data) {
		if(root == null) {
			return root;
		}
		if(data<root.data) {
			root.left = delete_node(root.left,data);
		}
		else if(data>root.data) {
			root.right = delete_node(root.right,data);
		}
		else {
			if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			else {
				root.data = get_min(root.right);
				root.right = delete_node(root.right,root.data);
			}
		}
		return root;
	}
	
	public boolean search(TreeNode root,int data) {
		if(root == null) {
			return false;
		}
		else if(root.data == data) {
			return true;
		}
		else if(data<root.data) {
			return search(root.left,data);
		}
		else {
			return search(root.right,data);
		}
	}
	public int get_min(TreeNode t) {
		while(t.left != null) {
			t = t.left;
		}
		return t.data;
	}
	
	public int get_max(TreeNode t) {
		while(t.right != null) {
			t = t.right;
		}
		return t.data;
	}
	
	public int get_height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(get_height(root.left),get_height(root.right))+1;
	}
	
	public TreeNode get_root() {
		return root;
	}
	
	public void inorder_traversal(TreeNode root) {
		if(root!=null) {
		inorder_traversal(root.left);
		System.out.println(root.data);
		inorder_traversal(root.right);
		}
	}
	
	public void preorder_traversal(TreeNode root) {
		if(root!=null) {
			System.out.println(root.data);
			preorder_traversal(root.left);
			preorder_traversal(root.right);
			}
		}
	public void postorder_traversal(TreeNode root) {
		if(root!=null) {
			postorder_traversal(root.left);
			preorder_traversal(root.right);
			System.out.println(root.data);
			}
	}
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}
	public void print_path(TreeNode root, int data) {
		if(root == null) {
			System.out.println("doesnot exist");
		}
		else if(root.data == data) {
			System.out.println("done");
		}
		else if(data<root.data) {
			System.out.println(root.data);
			print_path(root.left,data);
		}
		else {
			System.out.println(root.data);
			print_path(root.right,data);
		}
	}
	public TreeNode LCA(TreeNode root, int a, int b) {
		if(search(root,a) && search(root,b)) {
		if(root.data == a || root.data == b) {
			return root;
		}
		else {
			if(a<root.data && b<root.data) {
				return LCA(root.left,a,b);
			}
			else if(a>root.data && b>root.data) {
				return LCA(root.right,a,b);
			}
			else {
				return root;
			}
		}
		}
		else {
			return null;
		}
	}
	public TreeNode inorder_to_bst(List<Integer> a) {
		if(a.size() == 0) {
			return null;
		}
		else {
			int mid = a.size()/2;
			TreeNode r = new TreeNode(a.get(mid));
			r.left = inorder_to_bst(a.subList(0, mid));
			r.right = inorder_to_bst(a.subList(mid+1, a.size()));
			return r;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST b = new BST();
		b.insert(10);
		b.insert(20);
		b.insert(5);
		b.insert(3);
		b.insert(1);
		b.insert(8);
		b.insert(9);
		//System.out.println(b.get_height(b.get_root()));
		//b.inorder_traversal(b.get_root());
		//b.preorder_traversal(b.get_root());
		//b.postorder_traversal(b.get_root());
		//b.print_path(b.get_root(), 25);
		//System.out.println(b.search(b.get_root(), 25));
		//System.out.println(b.LCA(b.get_root(), 3, 9));
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		TreeNode r = b.inorder_to_bst(a);
		b.inorder_traversal(r);
	}

}
