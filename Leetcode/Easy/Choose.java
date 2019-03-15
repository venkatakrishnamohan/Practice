import java.io.*;
import java.util.*;

class Choose{
    public List<String> choosenk(String s, int k){
        List<String> res = new ArrayList<>();
        String current = "";
        choosenkHelper(s, k, current,res);
        return res;
    }
    public void choosenkHelper(String s, int k, String curr,List<String> res){
        if(k==0){
            res.add(curr);
            return;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            curr = curr+ch;
            choosenkHelper(s,k-1,curr,res);
            curr = curr.substring(0,curr.length()-1);
        }
    }
    public void testOne(){
        String s = "abcd";
        List<String> res = choosenk(s,2);
        System.out.println(res);
    }
    public static void main(String args[]){
        Choose s = new Choose();
        s.testOne();
    }
}