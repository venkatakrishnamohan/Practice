import java.io.*;
import java.util.*;

class Knapsack{
    public int Knapsack01(int[] w, int[] v, int W){
        return Knapsack01Helper(w,v,W);
    }
    public int Knapsack01Helper(int[] w, int[] v, int W){
        int[][] dp = new int[W+1][w.length+1];
        for(int i=0;i<=W;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=w.length;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=W;i++){
            for(int j=1;j<=w.length;j++){
                if(w[j-1]<=i){
                    dp[i][j] = v[j-1]+dp[i-w[j-1]][j-1];
                }
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
            }
        }
        return dp[W][w.length];
    }
    public void testOne(){
        int[] v = new int[]{60,100,120};
        int[] w = new int[]{10,20,30};
        int W = 50;
        System.out.println(Knapsack01(w,v,W));
    }
    public static void main(String args[]){
        Knapsack s = new Knapsack();
        s.testOne();
    }
}