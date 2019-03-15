import java.io.*;
import java.util.*;

class Bipartite{
    public boolean isBipartite(){
        int[][] g = createGraph();
        int[] visited  = new int[g.length];
        for(int i=0;i<visited.length;i++){
            visited[i] = 0;
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i] == 0){
                if(!isBipartiteHelper(g,visited,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartiteHelper(int[][] graph, int[] visited, int i){
        visited[i] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            List<Integer> neighbors = getNeighbors(q.peek(),graph);
            for(int n: neighbors){
                if(visited[n] == 0){
                    if(visited[q.peek()] == 1){
                        visited[n] = 2;
                    }
                    else{
                        visited[n] = 1;
                    }
                    q.add(n);
                }
                else if(visited[n] == visited[q.peek()]){
                    return false;
                }
            }
            q.poll();
        }
        return true;
    }
    public List<Integer> getNeighbors(int n, int[][] graph){
        int[] row = graph[n];
        List<Integer> neighbors = new ArrayList<>();
        for(int i=0;i<row.length;i++){
            if(row[i] != 0){
                neighbors.add(i);
            }
        }
        return neighbors;
    }
    public int[][] createGraph(){
        int[][] graph = new int[][]{
            {0,1},
            {1,0}
        };
        return graph;
    }
    public void testOne(){
        if(isBipartite()){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    public static void main(String args[]){ 
        Bipartite s = new Bipartite();
        s.testOne();
    }
}