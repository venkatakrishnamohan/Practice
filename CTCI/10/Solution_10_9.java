import java.io.*;
import java.util.*;

class Solution_10_9{
    public boolean matSearch(int[][] mat, int x){
        int row = 0;
        int col = mat[0].length -1;
        while(row < mat.length && col >=0){
            if(mat[row][col] == x){
                return true;
            }
            else if(mat[row][col] > x){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
    public void testOne(){
        int[][] mat = new int[][] {
            {15,20,40,85},
            {20,35,80,95},
            {30,55,95,105},
            {40,80,100,120}
        };
        if(matSearch(mat, 55)){
            System.out.println("Found");
        }
        else{
            System.out.println("Doesnt exist");
        }
    }
    public static void main(String args[]){
        Solution_10_9 s = new Solution_10_9();
        s.testOne();
    }
}