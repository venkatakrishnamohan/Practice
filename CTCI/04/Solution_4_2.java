import java.io.*;
import java.util.*;

class Solution_4_2{
    public treeNode buildTree(int[] array){
            return buildTreeHelper(array,0,array.length-1);
    }
    public treeNode buildTreeHelper(int[] arr, int start, int end){
        if(end < start){
            return null;
        }
        int midInd = (start+end)/2;
        int mid = arr[midInd];
        treeNode t = new treeNode(mid);
        t.left = buildTreeHelper(arr, start, midInd - 1);
        t.right = buildTreeHelper(arr, midInd + 1, end);
        return t;
    }
    public int[] traverse(int[] arr, treeNode t){
        int[] res = new int[arr.length];
        int ind = 0;
        inOrder(t,res,ind);
        return res;
    }
    public void inOrder(treeNode t, int[] res, int i){
        if(t == null){
            return;
        }
        inOrder(t.left,res,i);
        res[i++] = t.data;
        System.out.println(t.data);
        inOrder(t.right,res,i);
    }
    public void testOdd(){
        int[] treedata = new int[]{1,2,3,4,5};
        treeNode t = buildTree(treedata);
        boolean flag = true;
        int[] res = traverse(treedata, t);
    }
    public void testEven(){
        int[] treedata = new int[]{1,2,3,4};
        treeNode t = buildTree(treedata);
        boolean flag = true;
        int[] res = traverse(treedata, t);
    }
    public void testEmpty(){
        int[] treedata = new int[]{};
        treeNode t = buildTree(treedata);
        boolean flag = true;
        if(t == null){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        int[] treedata = new int[]{1};
        treeNode t = buildTree(treedata);
        boolean flag = true;
        int[] res = traverse(treedata, t);
    }
    public void testEven2(){
        int[] treedata = new int[]{1,2};
        treeNode t = buildTree(treedata);
        boolean flag = true;
        int[] res = traverse(treedata, t);
    }
    public static void main(String args[]){
        Solution_4_2 s = new Solution_4_2();
        s.testEmpty();
        s.testEven();
        s.testEven2();
        s.testOdd();
        s.testOne();
    }
}