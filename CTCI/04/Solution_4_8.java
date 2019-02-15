import java.io.*;
import java.util.*;

class Solution_4_8{
    public treeNode firstCommonAncestor(treeNode root, treeNode a, treeNode b){
        if(contains(root,a) && contains(root,b)){
            return firstCommonAncestorHelper(root,a,b);
        }
        else{
            return null;
        }
    }
    public treeNode firstCommonAncestorHelper(treeNode root, treeNode a, treeNode b){
        if(root == null){
            return null;
        }
        if(root == a && root == b){
            return root;
        }
        else if(root == a || root == b){
            return root;
        }
        treeNode left = firstCommonAncestorHelper(root.left, a, b);
        if(left != null && left != a && left != b){
            return left;
        }
        treeNode right = firstCommonAncestorHelper(root.right, a, b);
        if(right != null && right != a && right != b){
            return right;
        }
        if(left != null && right != null){
            return root;
        }
        else{
            if(left == null){
                return right;
            }
            else{
                return left;
            }
        }
    }
    public boolean contains(treeNode root, treeNode t){
        if(root == null){
            return false;
        }
        if(root == t){
            return true;
        }
        return contains(root.left,t) || contains(root.right,t);
    }
    public void test1(){
        treeNode t = new treeNode(30);
        treeNode t2 = new treeNode(20);
        treeNode t3 = new treeNode(40);
        treeNode t4 = new treeNode(10);
        t.left = t2;
        t.right = t3;
        t2.left = t4;
        treeNode fca = firstCommonAncestor(t,t2,t3);
        if(fca == t){
            System.out.println("Testcase passed");
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
        treeNode fca = firstCommonAncestor(t,t3,t4);
        if(fca == t2){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEmpty(){
        treeNode t = new treeNode(10);
        treeNode t2 = new treeNode(20);
        if(null == firstCommonAncestor(null,t,t2)){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void test3(){
        treeNode t = new treeNode(10);
        treeNode t2 = new treeNode(20);
        treeNode t3 = new treeNode(30);
        treeNode t4 = new treeNode(40);
        treeNode t5 = new treeNode(50);
        t.left = t2;
        t2.left = t3;
        t2.right = t4;
        treeNode fca = firstCommonAncestor(t,t3,t5);
        if(fca == null){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_4_8 s = new Solution_4_8();
        s.test1();
        s.test2();
        s.test3();
        s.testEmpty();
    }
}