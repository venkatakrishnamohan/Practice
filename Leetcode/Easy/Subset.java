import java.io.*;
import java.util.*;

class Subset{
    public boolean SubsetSum(int[] a,int sum){
        List<Integer> al = new ArrayList<>();
        for(int i:a){
            al.add(i);
        }
        return SubsetSumHelper(al,sum);
    }
    public boolean SubsetSumHelper(List<Integer> a,int sum){
        if(sum == 0){
            return true;
        }
        if(a.size() == 0){
            return false;
        }
        int c = a.get(0);
        a.remove(0);
        boolean include = false;
        if(c<=sum){
            include = SubsetSumHelper(a,sum-c);
        }
        boolean exclude = SubsetSumHelper(a,sum);
        a.add(0,c);
        return include | exclude;
    }
    public boolean SubsetSumDp(int[] a, int sum){
        boolean[][] dp = new boolean[sum+1][a.length+1];
        for(int i=0;i<=a.length;i++){
            dp[0][i] = true;
        }
        for(int i=0;i<=sum;i++){
            dp[i][0] = false;
        }
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=a.length;j++){
                if(a[j-1]>i){
                    dp[i][j] = dp[i][j-1]; 
                }
                else{
                    dp[i][j] = dp[i][j-1] || dp[i-a[j-1]][j-1];
                }
            }
        }
        return dp[sum][a.length];
    }
    public void testOne(){
        int[] a = new int[]{3,34,4,12,5,2};
        int sum = 9;
        if(SubsetSum(a,sum)){
            System.out.println("Exists");
        }
        else{
            System.out.println("Doesn't Exist");
        }
    }
     public void testTwo(){
        int[] a = new int[]{3,34,4,12,5,2};
        int sum = 9;
        if(SubsetSumDp(a,sum)){
            System.out.println("Exists");
        }
        else{
            System.out.println("Doesn't Exist");
        }
    }
    public static void main(String args[]){
        Subset s = new Subset();
        s.testOne();
        s.testTwo();
    }
}