import java.io.*;
import java.util.*;

class IncrSeq{
    public List<List<Integer>> getIncrSeq(int n, int k){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        getIncrSeqHelper(n,0,k,curr,res);
        return res;
    }
    public void getIncrSeqHelper(int n, int c,int k, List<Integer> curr, List<List<Integer>> res){
        if(k==0){
            List<Integer> l = new ArrayList<>(curr);
            res.add(l);
            return;
        }
        if(n-c<k){
            return;
        }
        curr.add(c+1);
        getIncrSeqHelper(n,c+1,k-1,curr,res);
        curr.remove(curr.size()-1);
        getIncrSeqHelper(n,c+1,k,curr,res);
    }
    public void testOne(){
        List<List<Integer>> res = getIncrSeq(5,3);
        System.out.println(res);
    }
    public static void main(String args[]){
        IncrSeq s = new IncrSeq();
        s.testOne();
    }
}