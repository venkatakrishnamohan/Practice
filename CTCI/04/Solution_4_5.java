import java.io.*;
import java.util.*;

class Solution_4_5{
    public boolean validBST(treeNode t){
        return validBSTHelper(t,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean validBSTHelper(treeNode t, int min_val, int max_val){
        if(t == null){
            return true;
        }
        boolean left = validBSTHelper(t.left,min_val,t.data);
        boolean right = validBSTHelper(t.right,t.data,max_val);
        if(right && left && t.data >= min_val && t.data <= max_val){
            return true;
        }
        else{
            return false;
        }
    }
    public void testEmpty(){
        if(validBST(null)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testFalse(){
        treeNode t = new treeNode(10);
        treeNode t2 = new treeNode(20);
        treeNode t3 = new treeNode(30);
        treeNode t4 = new treeNode(40);
        t.left = t2;
        t2.left = t3;
        t2.right = t4;
        if(!validBST(t)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testTrue(){
        treeNode t = new treeNode(30);
        treeNode t2 = new treeNode(20);
        treeNode t3 = new treeNode(40);
        treeNode t4 = new treeNode(10);
        t.left = t2;
        t.right = t3;
        t2.left = t4;
        if(validBST(t)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        treeNode t = new treeNode(10);
        if(validBST(t)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testTrue2(){
        treeNode t = new treeNode(30);
        treeNode t2 = new treeNode(20);
        treeNode t3 = new treeNode(10);
        treeNode t4 = new treeNode(40);
        treeNode t5 = new treeNode(35);
        t.left = t2;
        t.right = t4;
        t2.left = t3;
        t4.left = t5;
        if(validBST(t)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_4_5 s = new Solution_4_5();
        s.testEmpty();
        s.testFalse();
        s.testOne();
        s.testTrue();
        s.testTrue2();
    }
}