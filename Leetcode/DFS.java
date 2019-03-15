import java.io.*;
import java.util.*;

class DFS{
    public List<Integer> DepthFs(){
        int start = 0;
        int[][] graph = createGraph();
        List<Integer> visited = new ArrayList<>();
        visited.add(start);
        DepthFsHelper(start,visited,graph);
        return visited;
    }
    public void DepthFsHelper(int n, List<Integer> visited, int[][] graph){
        if(n==-1){
            return;
        }
        List<Integer> neighbors = getNeighbors(n,graph);
        for(int i=0;i<neighbors.size();i++){
            if(!visited.contains(neighbors.get(i))){
                visited.add(neighbors.get(i));
                DepthFsHelper(neighbors.get(i),visited, graph);
            }
        }
    }
    public List<Integer> BreadthFs(){
        int start = 0;
        int[][] graph = createGraph();
        List<Integer> queue = new ArrayList<>();
        queue.add(start);
        return BreadthFsHelper(start,queue,graph);
    }
    public List<Integer> BreadthFsHelper(int n, List<Integer> queue, int[][] graph){
        List<Integer> visited = new ArrayList<>();
        while(queue.size()!=0){
            int cur = queue.get(0);
            visited.add(cur);
            List<Integer> neighs = getNeighbors(cur, graph);
            for(int i=0;i<neighs.size();i++){
                if(!visited.contains(neighs.get(i)) && !queue.contains(neighs.get(i))){
                    queue.add(neighs.get(i));
                }
            }
            queue.remove(0);
        }
        return visited;
    }
    public List<Integer> getPath(int x, int y){
        return null;
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
    public void testDFS(){
        System.out.println(DepthFs());
    }
    public void testBFS(){
        System.out.println(BreadthFs());
    }
    public void testPath(){
        System.out.println(getPath(1,6));
    }
    public int[][] createGraph(){
        int[][] graph = new int[][]{
            {0,1,1,0,0,0,0},
            {1,0,1,0,1,0,0},
            {1,1,0,0,1,0,0},
            {0,0,0,0,1,1,0},
            {0,1,1,1,0,0,1},
            {0,0,0,1,0,0,1},
            {0,0,0,0,1,1,0}
        };
        return graph;
    }
    public static void main(String args[]){
        DFS s = new DFS();
        s.testDFS();
        s.testBFS();
        s.testPath();
    }
}