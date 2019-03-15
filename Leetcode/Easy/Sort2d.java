import java.io.*;
import java.util.*;

class Sort2d{
    public int[][] sort2dArray(int[][] arr){
        Arrays.sort(arr,new Comparator2d());
        return arr;
    }
    public void testOne(){
        int[][] arr = new int[][]{
            {1,2},
            {0,1},
            {1,1},
            {2,3},
            {-1,4}
        };
        int[][] res = sort2dArray(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i][0]);
            System.out.print(" ");
            System.out.print(res[i][1]);
            System.out.println("");
        }
    }
    public static void main(String args[]){
        Sort2d s = new Sort2d();
        s.testOne();
    }
}

class Comparator2d implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        int dista = a[0]*a[0]+a[1]*a[1];
        int distb = b[0]*b[0]+b[1]*b[1];
        if(dista > distb){
            return 1;
        }
        else if(dista < distb){
            return -1;
        }
        else{
            return 0;
        }
    }
}