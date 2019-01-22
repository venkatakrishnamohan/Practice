import java.util.ArrayList;

public class DFS {
	ArrayList<Integer> visited = new ArrayList<>();
	ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
	int V;
	
	public DFS(int V) {
		this.V = V;
		for(int i=0;i<V;i++) {
			adjlist.add(new ArrayList<>());
		}
	}
	
	public void addedge(int a, int b) {
		adjlist.get(a).add(b);
	}
	
	public void dfs(int v) {
		System.out.println(v);
		visited.add(v);
		ArrayList<Integer> neighbors = get_neighbors(v);
		for(int n : neighbors){
			if(!visited.contains(n)) {
				dfs(n);
			}
		}
		return;
	}

	public ArrayList<Integer> get_neighbors(int n) {
		return adjlist.get(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS d = new DFS(5);
		d.addedge(0,1);
		d.addedge(1,2);
		d.addedge(2,1);
		d.addedge(1,0);
		d.addedge(2, 4);
		d.addedge(4, 2);
		d.addedge(3, 4);
		d.addedge(4, 3);
		d.dfs(0);
	}

}
