import java.io.*;
import java.util.*;

class PowerSet{
    public List<String> getPowerSet(String s){
        List<String> res = new ArrayList();
        String chosen = "";
        getPowerSetHelper(s,chosen, res);
        return res;
    }
    public void getPowerSetHelper(String s, String chosen,List<String> res){
        if(s.length() == 0){
            res.add(chosen);
            return;
        }
        char c = s.charAt(0);
        s = s.substring(1);
        getPowerSetHelper(s,chosen, res);
        chosen = chosen+c;
        getPowerSetHelper(s,chosen,res);
    }
    public void testOne(){
        String s = "abc";
        List<String> res = getPowerSet(s);
        System.out.println(res);
    }
    public static void main(String args[]){
        PowerSet s = new PowerSet();
        s.testOne();
    }
}