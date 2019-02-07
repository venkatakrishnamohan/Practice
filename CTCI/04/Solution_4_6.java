import java.io.*;
import java.util.*;

class Solution_4_6{
    public treeNodeP inOrderSuccessor(treeNodeP t){
        if(t == null){
            return null;
        }
        else if(t.right != null){
            return getMin(t.right);
        }
        else{
            treeNodeP parent = t.parent;
            treeNodeP curr = t;
            while(parent!=null && parent.left != curr){
                curr = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
    public treeNodeP getMin(treeNodeP curr){
        if(curr == null){
            return null;
        }
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
    public void testEmpty(){
        if(null == inOrderSuccessor(null)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        treeNodeP t = new treeNodeP(10);
        if(null == inOrderSuccessor(t)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testRight(){
        treeNodeP t = new treeNodeP(30);
        treeNodeP t2 = new treeNodeP(20);
        treeNodeP t3 = new treeNodeP(40);
        treeNodeP t4 = new treeNodeP(10);
        treeNodeP t5 = new treeNodeP(25);
        t.left = t2;
        t.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.parent = t2;
        t2.parent = t;
        t3.parent = t;
        t4.parent = t2;
        if(t5 == inOrderSuccessor(t2)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testLeft(){
        treeNodeP t = new treeNodeP(30);
        treeNodeP t2 = new treeNodeP(20);
        treeNodeP t3 = new treeNodeP(40);
        treeNodeP t4 = new treeNodeP(10);
        treeNodeP t5 = new treeNodeP(25);
        treeNodeP t6 = new treeNodeP(15);
        t.left = t2;
        t.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.right = t6;
        t6.parent = t4;
        t5.parent = t2;
        t2.parent = t;
        t3.parent = t;
        t4.parent = t2;
        if(t2 == inOrderSuccessor(t6)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testNull(){
        treeNodeP t = new treeNodeP(30);
        treeNodeP t2 = new treeNodeP(20);
        treeNodeP t3 = new treeNodeP(40);
        treeNodeP t4 = new treeNodeP(10);
        treeNodeP t5 = new treeNodeP(25);
        treeNodeP t6 = new treeNodeP(15);
        t.left = t2;
        t.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.right = t6;
        t6.parent = t4;
        t5.parent = t2;
        t2.parent = t;
        t3.parent = t;
        t4.parent = t2;
        if(null == inOrderSuccessor(t3)){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_4_6 s = new Solution_4_6();
        s.testEmpty();
        s.testLeft();
        s.testNull();
        s.testOne();
        s.testRight();
    }
}