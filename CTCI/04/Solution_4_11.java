import java.io.*;
import java.util.*;

class Solution_4_11{
    public void insert(treeNodeRand root, int data){
        if(data <= root.data){
            if(root.left == null){
                root.left = new treeNodeRand(data);
            }
            else{
                insert(root.left,data);
            }
        }
        else{
            if(root.right == null){
                root.right = new treeNodeRand(data);
            }
            else{
                insert(root.right,data);
            }
        }
        root.size+=1;
    }
    public treeNodeRand getRandomNode(treeNodeRand root){
        Random r = new Random();
        int ind = r.nextInt(root.size);
        int noOfElementsonLeft = 0;
        if(root.left != null){
            noOfElementsonLeft = root.left.size;
        } 
        if(ind < noOfElementsonLeft){
            return getRandomNode(root.left);
        }
        else if(ind == noOfElementsonLeft){
            return root;
        }
        else{
            return getRandomNode(root.right);
        }
    }
    public void test1(){
        treeNodeRand t = new treeNodeRand(30);
        insert(t,10);
        insert(t,5);
        insert(t,35);
        insert(t,25);
        System.out.println(getRandomNode(t).data);
    }
    public static void main(String args[]){
        Solution_4_11 s = new Solution_4_11();
        s.test1();
        s.test1();
        s.test1();
    }
}