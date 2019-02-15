import java.io.*;
import java.util.*;

class Solution_8_12{
    public void placeQueens(int n){
        int[] curr_pos = new int[n];
        for(int i=0;i<curr_pos.length;i++){
            curr_pos[i] = -1;
        }
        placeQueensHelper(0,n,curr_pos);
    }
    public void placeQueensHelper(int cq, int n, int[] places){
        System.out.println(cq);
        if(cq == n){
            //ArrayList na = new ArrayList(places.size());
            //Collections.copy(na, places);
            System.out.println(places);
            //res.add(na);
        }
        for(int i=0;i<n;i++){
            if(checkValid(cq,i,places)){
                places[cq] = i;
                System.out.println(i);
                placeQueensHelper(cq+1,n,places);
                places[cq] = -1;
            }
        }
    }
    public boolean checkValid(int row, int col, int[] places){
        for(int i=0;i<places.length;i++){
            int col2 = places[i];
            if(col == col2){
                return false;
            }
            if(Math.abs(i-row) == Math.abs(col2 - col)){
                return false;
            }
        }
        return true;
    }
    public void testOne(){
        placeQueens(8);
    }
    public static void main(String args[]){
        Solution_8_12 s = new Solution_8_12();
        s.testOne();
    }
}