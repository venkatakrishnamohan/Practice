import java.io.*;
import java.util.*;

class Solution_8_2{
    public List<List<Integer>> getPath(int[][] mat){
        int rows = mat.length;
        int cols = 0;
        if(rows > 0){
            cols = mat[0].length;
        }
        List<List<Integer>> path = new ArrayList<List<Integer>>();
        Set<List<Integer>> noPathIndices = new HashSet<List<Integer>>();
        getPathHelper(mat, path, rows-1, cols-1, rows, cols, noPathIndices);
        return path;
    }
    public boolean getPathHelper(int[][] mat, List<List<Integer>> path, int rno, int cno, int rows, int cols, Set<List<Integer>> noPathIndices){
        if(rno == 0 && cno ==0){
            return true;
        }
        if(rno < 0 || cno < 0 || rno > rows-1 || cno > cols-1){
            return false;
        }
        if(mat[rno][cno] == 1){
            return false;
        }
        List<Integer> l = new ArrayList<>();
        l.add(rno);
        l.add(cno);
        if(noPathIndices.contains(l)){
            return false;
        }
        if(getPathHelper(mat, path, rno-1, cno, rows, cols,noPathIndices) || getPathHelper(mat, path, rno, cno-1, rows, cols, noPathIndices)){
            path.add(l);
            return true;
        }
        noPathIndices.add(l);
        return false;
    }
    public void testOne(){
        int[][] mat = new int[][]{
            {0,0,1,0,0},
            {0,0,0,1,1},
            {1,0,0,1,0},
            {1,1,0,0,0},
            {0,0,1,0,0}
        };
        List<List<Integer>> l = getPath(mat);
        System.out.println(l);
    }
    public static void main(String args[]){
        Solution_8_2 s = new Solution_8_2();
        s.testOne();
    }
}