import java.io.*;
import java.util.*;

class Solution_4_4{
    int error = Integer.MIN_VALUE;
    public boolean checkBalanced(treeNode t){
        return checkHeight(t) != error;
    }
    public int checkHeight(treeNode t){
        if(t == null){
            return -1;
        }
        int leftHeight = checkHeight(t.left);
        if(leftHeight == error){
            return error;
        }
        int rightHeight = checkHeight(t.right);
        if(rightHeight == error){
            return error;
        }

        int diff = leftHeight - rightHeight;
        if(Math.abs(diff) > 1){
            return error;
        }
        else{
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
    public void testEmpty(){
        if(checkBalanced(null)){
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
        if(!checkBalanced(t)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testTrue(){
        treeNode t = new treeNode(10);
        treeNode t2 = new treeNode(20);
        treeNode t3 = new treeNode(30);
        treeNode t4 = new treeNode(40);
        t.left = t2;
        t.right = t3;
        t2.left = t4;
        if(checkBalanced(t)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        treeNode t = new treeNode(10);
        if(checkBalanced(t)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testFalse2(){
        treeNode t = new treeNode(10);
        treeNode t2 = new treeNode(20);
        treeNode t3 = new treeNode(30);
        treeNode t4 = new treeNode(40);
        t.right = t2;
        t2.right = t3;
        t3.right = t4;
        if(!checkBalanced(t)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_4_4 s = new Solution_4_4();
        s.testEmpty();
        s.testFalse();
        s.testTrue();
        s.testFalse2();
        s.testOne();
    }

}