import java.io.*;
import java.util.*;

class Solution_10_1{
    public int[] merge(int[] a, int[] b){
        int aLength = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] == -1){
                break;
            }
            aLength++;
        }
        aLength-=1;
        int bLength = b.length-1;
        int end = a.length-1;
        while(bLength >= 0){
            if(aLength >= 0 && a[aLength] >= b[bLength]){
                a[end] = a[aLength];
                aLength-=1;
            }
            else{
                a[end] = b[bLength];
                bLength-=1;
            }
            end-=1;
        }
        return a;
    }
    public void testOne(){
        int[] a = {3,4,5,-1,-1,-1};
        int[] b = {1,2,3};
        int[] res = merge(a,b);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
    public static void main(String args[]){
        Solution_10_1 s = new Solution_10_1();
        s.testOne();
    }
}