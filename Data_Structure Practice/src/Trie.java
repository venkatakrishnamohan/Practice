import java.util.ArrayList;

public class Trie {
	Trie[] t = new Trie[26];
	boolean done = false;
	
	public Trie(){
		for(int i=0;i<t.length;i++) {
			t[i] = null;
		}
	}
	static Trie root;
	
	public void insert(String s) {
		
		Trie tr = root;
		for(int i=0;i<s.length();i++) {
			int j = s.charAt(i) - 'a';
			if(tr.t[j] == null) {
				tr.t[j] = new Trie();
			}
			tr = tr.t[j];
		}
		tr.done = true;
	}
	
	public boolean search(String s) {
		Trie tr = root;
		for(int i=0;i<s.length();i++) {
			int j = s.charAt(i) - 'a';
			if(tr.t[j] != null) {
				tr = tr.t[j];
				continue;
			}
			else {
			return false;
			}
		}
		if(tr.done == true) {
			return true;
		}
		return false;
	}
	public ArrayList<Integer> get_count(Trie t){
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0;i<t.t.length;i++) {
			if(t.t[i] != null) {
				al.add(i);
			}
		}
		return al;
	}
	public String common_prefix() {
		Trie tr = root;
		String s = "";
		ArrayList<Integer> a = get_count(tr);
		while(a.size() == 1 && tr.done == false) {
			s = s+ (char) (a.get(0) + 'a');
			tr = tr.t[a.get(0)];
			a = get_count(tr);
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String keys[] = {"the", "there", "their"}; 
		root = new Trie();
		int i; 
        for (i = 0; i < keys.length ; i++) 
            root.insert(keys[i]); 
        
        System.out.println(root.common_prefix());
		
	}

}
