import java.io.*;
import java.util.*;

class TopSort{
    public void TopologicalSort(){
        int[][]graph = createGraph();
        Stack<Integer> res = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        for(int i=0;i<visited.length;i++){
            visited[i] = false;
        }
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                TopologicalSortHelper(graph,res,visited,i);
            }
        }
        while(!res.isEmpty()){
            System.out.println(res.pop());
        }
    }
    public void TopologicalSortHelper(int[][] graph,Stack<Integer> res,boolean[] visited, int v){
        visited[v] = true;
        List<Integer> neighbors = getNeighbors(v, graph);
        for(int n:neighbors){
            if(!visited[n]){
                TopologicalSortHelper(graph,res,visited,n);
            }
        }
        res.push(new Integer(v));
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
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,1,0,0},
            {0,1,0,0,0,0},
            {1,1,0,0,0,0},
            {1,0,1,0,0,0}
        };
        return graph;
    }
    public void testOne(){
        TopologicalSort();
    }
    public static void main(String args[]){
        TopSort s = new TopSort();
        s.testOne();
    }
}