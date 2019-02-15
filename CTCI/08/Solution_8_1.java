import java.io.*;
import java.util.*;

class Solution_8_1{
    public int tripleStep(int n){
        int[] memo = new int[n+1];
        memo[0] = 1;
        int a=0;
        int b=0;
        int c=0;
        for(int i=1;i<=n;i++){
            if(i-1<0){
                a = 0;
            }
            else{
                a = memo[i-1];
            }
            if(i-2<0){
                b = 0;
            }
            else{
                b = memo[i-2];
            }
            if(i-3<0){
                c = 0;
            }
            else{
                c = memo[i-3];
            }
            memo[i] = a+b+c;
        }
        return memo[n];
    }
    public void testTwo(){
        if(2 == tripleStep(2)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testThree(){
        if(4 == tripleStep(3)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testSome(){
        System.out.println(tripleStep(10));
    }
    public static void main(String args[]){
        Solution_8_1 s = new Solution_8_1();
        s.testSome();
        s.testThree();
        s.testTwo();
    }
}