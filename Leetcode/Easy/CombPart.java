import java.io.*;
import java.util.*;

class CombPart{
    public List<List<String>> getCombPart(String s){
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> curr = new ArrayList<>();
        getCombPartHelper(s, curr, res);
        return res;
    }
    public void getCombPartHelper(String s, List<String> curr, List<List<String>> res){
        if(s.length() == 0){
            List<String> r = new ArrayList<>(curr);
            res.add(r);
            return;
        }
        for(int i=0;i<s.length();i++){
            String part = s.substring(0,i+1);
            String rem = s.substring(i+1,s.length());
            curr.add(part);
            getCombPartHelper(rem, curr, res);
            String last = curr.get(curr.size()-1);
            s = last+rem;
            curr.remove(curr.size()-1);
        }
    }
    public void testOne(){
        List<List<String>> res = getCombPart("1214");
        System.out.println(res);
    }
    public static void main(String args[]){
        CombPart s = new CombPart();
        s.testOne();
    }
}