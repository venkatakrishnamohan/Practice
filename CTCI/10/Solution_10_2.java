import java.io.*;
import java.util.*;

class Solution_10_2{
    public String[] groupAnagrams(String[] sts){
        Arrays.sort(sts, new AnagramComparator());
        return sts;
    }
    public void testOne(){
        String[] sts = new String[]{
            "car","cat","ball","tac","arc","abll"
        };
        String[] ans = groupAnagrams(sts);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
    public static void main(String args[]){
        Solution_10_2 s = new Solution_10_2();
        s.testOne();
    }
}
class AnagramComparator implements Comparator<String>{
    @Override
    public int compare(String a, String b){
        char aArray[] = a.toCharArray();
        Arrays.sort(aArray);
        a = new String(aArray);
        char bArray[] = b.toCharArray();
        Arrays.sort(bArray);
        b = new String(bArray);
        return a.compareTo(b);
    }
}