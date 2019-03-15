import java.io.*;
import java.util.*;

class Vertical{
    public  Map<Integer, List<treeNode>> verticalOrder(treeNode root){
        Map<Integer, List<treeNode>> res = new HashMap<Integer,List<treeNode>>();
        verticalOrderHelper(root, res, 0);
        return res;
    }
    public void verticalOrderHelper(treeNode root, Map<Integer, List<treeNode>> res, int depth){
        if(root == null){
            return;
        }
        List<treeNode> curr = res.getOrDefault(depth,new ArrayList<treeNode>());
        curr.add(root);
        res.put(depth,curr);
        verticalOrderHelper(root.left,res,depth-1);
        verticalOrderHelper(root.right,res,depth+1);
    }
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
    public void testOne(){
        int[] treedata = new int[]{1,2,3,4,5};
        treeNode t = buildTree(treedata);
        Map<Integer, List<treeNode>> res = verticalOrder(t);
        System.out.println(res);
    }
    public static void main(String args[]){
        Vertical s = new Vertical();
        s.testOne();
    }
}