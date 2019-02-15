import java.io.*;
import java.util.*;

class Solution_8_4{
    public void getPowerSet(List<Integer> l){
        List<Integer> cs = new ArrayList<>();
        getPowerSetHelper(l,cs);
    }
    public void getPowerSetHelper(List<Integer> l, List<Integer> cs){
        if(l.size() ==0){
            System.out.println(cs);
            return;
        }
        int current_elem = l.get(0);
        cs.add(current_elem);
        l.remove(0);
        getPowerSetHelper(l,cs);
        cs.remove(cs.size()-1);
        getPowerSetHelper(l,cs);
        l.add(0,current_elem);
    }
    public void testOne(){
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        getPowerSet(l);
    }
    public static void main(String args[]){
        Solution_8_4 s = new Solution_8_4();
        s.testOne();
    }
}