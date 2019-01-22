import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstras {
	ArrayList<ArrayList<WeightedEdge>> adjlist = new ArrayList<>();
	int V;
	
	Dijkstras(int V) {
		this.V = V;
		for(int i=0;i<V;i++) {
			adjlist.add(new ArrayList<>());
		}
	}
	
	public void addedge(int a, int b, int w) {
		WeightedEdge e = new WeightedEdge(a,b,w);
		adjlist.get(a).add(e);
	}
	
	public ArrayList<WeightedEdge> get_neighbors(int n) {
		return adjlist.get(n);
	}
	
	public HashMap<Integer,Integer> shortest_path(int a, int b) {
		ArrayList<Integer> visited = new ArrayList<>();
		ArrayList<Integer> unvisited = new ArrayList<>();
		HashMap<Integer,Integer> dist = new HashMap<>();
		HashMap<Integer,Integer> path = new HashMap<>();
		visited.add(a);
		dist.put(a, 0);
		path.put(a, 0);
		for(int i=0;i<V;i++) {
			if(i != a) {
				unvisited.add(i);
				dist.put(i, Integer.MAX_VALUE);
				path.put(i,Integer.MAX_VALUE);
			}
		}
		while(!visited.contains(b)) {
			ArrayList<WeightedEdge> neighbors = get_neighbors(a);
			int min = Integer.MAX_VALUE;
			int min_node = Integer.MAX_VALUE;
			for(WeightedEdge e: neighbors) {
				if(unvisited.contains(e.destination) && dist.get(a)+e.weight < dist.get(e.destination)) {
					dist.put(e.destination,e.weight);
					path.put(e.destination, a);
				} 
			}
			for(int i: unvisited) {
				if(dist.get(i) < min) {
					min = dist.get(i);
					min_node = i;
				}
			}
			a = min_node;
			visited.add(a);
			for(int i=0;i<unvisited.size();i++) {
				if(unvisited.get(i) == a) {
					unvisited.remove(i);
					break;
				}
			}
		}
		return path;
	}
	
	public void print_path(int a, int b, HashMap<Integer,Integer> path) {
		System.out.println("Printing Path:");
		while(b!=a) {
			System.out.println(path.get(b));
			b= path.get(b);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dijkstras d = new Dijkstras(3);
		d.addedge(0,1,4);
		d.addedge(1,0,4);
		d.addedge(0,2,8);
		d.addedge(2,0,8);
		d.addedge(1, 2, 2);
		d.addedge(2, 1, 2);
		HashMap<Integer,Integer> path = d.shortest_path(0,2);
		d.print_path(0, 1, path);
	}

}
