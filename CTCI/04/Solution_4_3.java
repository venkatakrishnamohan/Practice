import java.io.*;
import java.util.*;

class Solution_4_3{
    public List<List<treeNode>> listDepths(treeNode t){
        List<List<treeNode>> res = new ArrayList<List<treeNode>>();
        List<treeNode> currLevel = new ArrayList<>();
        List<treeNode> prevLevel = new ArrayList<>();
        int i=0;
        if(t != null){
            currLevel.add(t);
        }
        while(currLevel.size()>0){
            res.add(currLevel);
            prevLevel = currLevel;
            currLevel = new ArrayList<>();
            for(int j=0;j<prevLevel.size();j++){
                if(prevLevel.get(i).left != null){
                    currLevel.add(prevLevel.get(i).left);
                }
                if(prevLevel.get(i).right != null){
                    currLevel.add(prevLevel.get(i).right);
                }
            }
        }
        return res;
    }
    public void testEmpty(){
        if(listDepths(null).size() == 0){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void printLists(List<List<treeNode>> res){
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                System.out.print(res.get(i).get(j).data+" ");
            }
            System.out.println("");
        }
    }
    public void testTree(){
        int[] treedata = new int[]{1,2,3};
        Solution_4_2 s = new Solution_4_2();
        treeNode t = s.buildTree(treedata);
        List<List<treeNode>> res = listDepths(t);
        printLists(res);
    }
    public static void main(String args[]){
        Solution_4_3 s = new Solution_4_3();
        s.testEmpty();
        s.testTree();
    }
}