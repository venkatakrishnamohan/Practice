import java.io.*;
import java.util.*;

class Test{
    public int countSteps(int[] arr){
        int[] val = new int[arr.length];
        val[0] = 0;
        for(int i=1;i<arr.length;i++){
            int min = Integer.MAX_VALUE;
            int count = 1;
            for(int j=i-1;j>=0;j--){
                if(count<=arr[j] && val[j]< min){
                    min = val[j];
                }
                count++;
            }
            val[i] = min+1;
            System.out.println(val[i]);
        }
        return val[arr.length-1];
    }
    public void testOne(){
        int[] arr = new int[]{1,3,5,8,9,2,6,7,6,8,9}; 
        System.out.println(countSteps(arr));
    }
    public static void main(String args[]){
        Test s = new Test();
        s.testOne();
    }
}