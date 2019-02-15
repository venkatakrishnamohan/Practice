import java.io.*;
import java.util.*;

class Solution_8_11{
    public int noOfWays(int val, List<Integer> denoms){
        int[][] map = new int[val+1][denoms.size()];
        return noOfWaysHelper(val, denoms,0,map);
    }
    public int noOfWaysHelper(int val, List<Integer> denoms, int index, int[][] map){
        if(map[val][index] != 0){
            return map[val][index];
        }
        if(index >= denoms.size()-1){
            return 1;
        }
        int ways = 0;
        int current_denom = denoms.get(index);
        int i=0;
        while(i*current_denom <= val){
            int valrem = val - i*current_denom;
            ways+=noOfWaysHelper(valrem, denoms, index+1, map);
            i+=1;
        }
        map[val][index] = ways;
        return ways;
    }
    public void testOne(){
        List<Integer> denoms = new ArrayList<>();
        denoms.add(25);
        denoms.add(10);
        denoms.add(5);
        denoms.add(1);
        int res = noOfWays(100,denoms);
        System.out.println(res);
    }
    public static void main(String args[]){
        Solution_8_11 s = new Solution_8_11();
        s.testOne();
    }
}