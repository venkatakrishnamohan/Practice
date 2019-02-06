import java.io.*;
import java.util.*;

class Solution_4_1{
    public boolean isRoute(int a, int b,int[][] adjMat){
        a-=1;
        b-=1;
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        bfs.add(a);
        s.add(a);
        while(bfs.size()!=0){
            int front = bfs.poll();
            if(front == b){
                return true;
            }
            int[] fneighs = getNeighbors(front, adjMat);
            for(int i=0;i<fneighs.length;i++){
                if(!s.contains(fneighs[i])){
                    s.add(fneighs[i]);
                    bfs.add(fneighs[i]);
                }
            }
        }
        return false;
    }
    public int[] getNeighbors(int a, int[][] adjMat){
        List<Integer> n = new ArrayList<>();
        int[] aneigs = adjMat[a];
        for(int i=0;i<aneigs.length;i++){
            if(aneigs[i] != 0){
                n.add(i);
            }
        }
        int[] res = new int[n.size()];
        for(int i=0;i<res.length;i++){
            res[i] = n.get(i);
        }
        return res;
    }
    public void testRoute(){
        int[][] adjMat = new int[][]{
            {0,1,0,1},
            {1,0,1,0},
            {0,1,0,1},
            {1,0,1,0}
        };
        if(isRoute(1,2,adjMat)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public void testRoute2(){
        int[][] adjMat = new int[][]{
            {0,1,0,1},
            {1,0,1,0},
            {0,1,0,1},
            {1,0,1,0}
        };
        if(isRoute(1,3,adjMat)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public void testEmpty(){
        int[][] adjMat = new int[][]{{}};
        if(!isRoute(1,2,adjMat)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public void testOne(){
        int[][] adjMat = new int[][]{{1}};
        if(isRoute(1,1,adjMat)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public void testDisjoint(){
        int[][] adjMat = new int[][]{
            {0,1,0,1,0},
            {1,0,1,0,0},
            {0,1,0,1,0},
            {1,0,1,0,0}
        };
        if(!isRoute(1,5,adjMat)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase failed");
        }
    }
    public static void main(String args[]){
        Solution_4_1 s = new Solution_4_1();
        s.testRoute();
        s.testRoute2();
        s.testEmpty();
        s.testOne();
        s.testDisjoint();
    }
}