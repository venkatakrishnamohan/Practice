import java.io.*;
import java.util.*;

class Solution_10_3{
    public int searchRotated(int[] arr, int elem){
        int low = 0;
        int high = arr.length;
        while(low<high){
            int mid = (low+high)/2;
            int midVal = arr[mid];
            if(midVal == elem){
                return mid;
            }
            else{
                if(midVal > arr[low]){
                    if(elem >= arr[low] && elem < midVal){
                        high = mid-1;
                    }
                    else{
                        low = mid+1;
                    }
                }
                else if(midVal < arr[low]){
                    if(elem > midVal && elem <= arr[high]){
                        low = mid +1;
                    }
                    else{
                        high = mid-1;
                    }
                }
                else{
                    if(midVal != a[high]){
                        low = mid+1;
                    }
                    else{
                        
                    }
                }
            }
        }
        return -1;
    }
    public void testOne(){
        int[] arr = new int[] {10,1,2,3,4,5};
        int res = searchRotated(arr, 5);
        System.out.println(res);
    }
    public static void main(String args[]){
        Solution_10_3 s = new Solution_10_3();
        s.testOne();
    }
}