import java.io.*;
import java.util.*;

class Solution_4_10{
    public boolean subTree(treeNode t1, treeNode t2){
        if(t2 == null){
            return true;
        }
        return isSubtree(t1,t2);
    }
    public boolean isSubtree(treeNode t1, treeNode t2){
        if(t1 == null){
            return false;
        }
        if(t1.data == t2.data && areEqual(t1,t2)){
            return true;
        }
        return isSubtree(t1.left,t2) || isSubtree(t1.right,t2);
    }
    public boolean areEqual(treeNode t1, treeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return t1.data == t2.data && areEqual(t1.left,t2.left) && areEqual(t1.right,t2.right);
    }
    public void test1(){
        treeNode t = new treeNode(10);
        treeNode t2 = new treeNode(20);
        treeNode t3 = new treeNode(30);
        treeNode t4 = new treeNode(40);
        t.left = t2;
        t2.left = t3;
        t2.right = t4;
        treeNode tc2 = new treeNode(20);
        treeNode tc3 = new treeNode(30);
        treeNode tc4 = new treeNode(40);
        tc2.left = tc3;
        tc2.right = tc4;
        if(subTree(t,tc2)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void test2(){
        treeNode t = new treeNode(10);
        treeNode t2 = new treeNode(20);
        treeNode t3 = new treeNode(30);
        treeNode t4 = new treeNode(40);
        t.left = t2;
        t2.left = t3;
        t2.right = t4;
        treeNode tc2 = new treeNode(20);
        treeNode tc3 = new treeNode(30);
        tc2.left = tc3;
        if(!subTree(t,tc2)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_4_10 s = new Solution_4_10();
        s.test1();
        s.test2();
    }
}