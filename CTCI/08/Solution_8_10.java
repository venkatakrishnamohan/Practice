import java.io.*;
import java.util.*;

class Solution_8_10{
    public int[][] paintFill(int[][] a, int row, int col, int val){
        paintFillHelper(a, row, col, val);
        return a;
    }
    public void paintFillHelper(int[][] a, int row, int col, int val){
        if(row < 0 || col < 0 || row > a.length-1 || col > a[0].length-1){
            return;
        }
        if(a[row][col] == val){
            return;
        }
        a[row][col] = val;
        paintFillHelper(a,row-1,col,val);
        paintFillHelper(a,row,col-1,val);
        paintFillHelper(a,row+1,col,val);
        paintFillHelper(a,row,col+1,val);
    }
    public void testOne(){
        int[][] a = new int[][]{
            {0,0,2,0},
            {2,0,0,0},
            {2,3,0,0},
            {0,0,0,0}
        };
        int[][] res = paintFill(a,2,2,1);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]);
            }
            System.out.println("");
        }
    }
    public static void main(String args[]){
        Solution_8_10 s = new Solution_8_10();
        s.testOne();
    }
}