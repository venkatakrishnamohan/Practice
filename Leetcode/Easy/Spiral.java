import java.io.*;
import java.util.*;

class Spiral{
    public int[][] printSpiral(int m){
        int[][] res = new int[m][m];
        int rs = 0;
        int rend = m;
        int cs = 0;
        int cend = m;
        int curr = 1;
        while(rs<rend && cs<cend){
            for(int i=cs;i<cend;i++){
                res[rs][i] = curr;
                curr++;
            }
            rs++;
            for(int i=rs; i<rend;i++){
                res[i][cend-1] = curr;
                curr++;
            }
            cend--;
            //if(rs<rend){
                for(int i=cend-1;i>=cs;i--){
                    res[rend-1][i] = curr;
                    curr++;
                }
                rend--;
            //}
            //if(cs<cend){
                for(int i=rend-1;i>=rs;i--){
                    res[i][cs] = curr;
                    curr++;
                }
                cs++;
            //}
        }
        return res;
    }
    public void testOne(){
        int[][] res = printSpiral(4);
        for(int[] r:res){
            for(int i:r){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public static void main(String args[]){
        Spiral s = new Spiral();
        s.testOne();
    }
}