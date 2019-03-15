import java.io.*;
import java.util.*;

class Spiral2{
    public int[][] printSpiral2(int n){
        int val = 1;
        int cxl = 0;
        int cyl = 0;
        int i = n/2;
        int j = n/2;
        int m = n/2;
        int res[][] = new int[n][n];
        //res[i][j] = val++;
        for(int layer = 1;m+layer<=n;layer++){
            while(j<=m+layer && j<n){
                res[i][j] = val++;
                j++;
            }
            System.out.println(i);
            System.out.println(j);
            if(i==0 && j==n){
                break;
            }
            i++;
            j--;
            while(i<=m+layer && i<n){
                res[i][j] = val++;
                i++;
            }
            i--;
            j--;
            print2d(res);
            while(j>=m-layer){
                res[i][j] = val++;
                j--;
            }
            j++;
            i--;
            while(i>=m-layer){
                res[i][j] = val++;
                i--;
            }
            i++;
            j++;
        }
        return res;
    }
    public void testOne(){
        int[][] res = printSpiral2(5);
        print2d(res);
    }
    public void print2d(int[][] res){
        for(int[] r:res){
            for(int c:r){
                System.out.print(c);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public static void main(String args[]){
        Spiral2 s = new Spiral2();
        s.testOne();
    }
}