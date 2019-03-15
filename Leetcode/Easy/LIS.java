import java.io.*;
import java.util.*;

class LIS{
    public int getLis(int[] arr){
        int[] res = new int[arr.length];
        res[0] =1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>=arr[j]){
                    if(res[j] >= res[i]){
                        res[i] = res[j]+1;
                    }
                }
            }
            if(res[i] == 0){
                res[i] =1;
            }
        }
        int maxres = Integer.MIN_VALUE;
        for(int i=0;i<res.length;i++){
            if(res[i] > maxres){
                maxres = res[i];
            }
        }
        return maxres;
    }
    public void testOne(){
        int[] a = new int[]{10,22,9,33,21,50,41,60,80};
        System.out.println(getLis(a));
    }
    public static void main(String args[]){
        LIS s = new LIS();
        s.testOne();
    }
}