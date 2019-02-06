import java.io.*;
import java.util.*;

class Solution_3_6_Helper{
    String name;
    int time;
    String type;
    static int curr_time = 0;
    public Solution_3_6_Helper(String name, String type){
        this.name = name;
        this.type = type;
        time = curr_time++;
    }
}