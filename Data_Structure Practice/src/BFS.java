import java.util.ArrayList;
import java.util.*; 

public class BFS {
	ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
	int V;
	
	public BFS(int V) {
		this.V = V;
		for(int i=0;i<V;i++) {
			adjlist.add(new ArrayList<>());
		}
	}
	
	public void addedge(int a, int b) {
		adjlist.get(a).add(b);
	}
	
	public void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> visited = new ArrayList<>();
		q.add(a);
		System.out.println(q);
		while(!q.isEmpty()) {
			int e = q.poll();
			System.out.println(e);
			visited.add(e);
			ArrayList<Integer> neighbors = get_neighbors(e);
			for(int i:neighbors) {
				if(!q.contains(i) && !visited.contains(i)) {
					q.add(i);
				}
			}
		}
	}
	
	public ArrayList<Integer> get_neighbors(int n) {
		return adjlist.get(n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS d = new BFS(6);
		d.addedge(0,1);
		d.addedge(1,2);
		d.addedge(2,1);
		d.addedge(1,0);
		d.addedge(2, 4);
		d.addedge(4, 2);
		d.addedge(3, 4);
		d.addedge(4, 3);
		d.addedge(0, 5);
		d.addedge(5, 0);
		d.bfs(0);
	}

}
