import java.io.*;
import java.util.*;

class Solution_8_3{
    public int getMagicIndex(int[] arr){
        int start = 0;
        int end = arr.length-1;
        // If non-unique search both sides. But can ignore some elements.
        // end = min(mid-1, value at mid)
        // start = min(mid+1, value at mid)
        while(start<=end){
            int mid = start+end/2;
            if(arr[mid] == mid){
                return mid;
            }
            else{
                if(arr[mid] > mid){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
    public void testOne(){
        int[] a = new int[]{1,2,3,4,9,10,11};
        int ans = getMagicIndex(a);
        System.out.println(ans);
    }
    public static void main(String args[]){
        Solution_8_3 s = new Solution_8_3();
        s.testOne();
    }
}