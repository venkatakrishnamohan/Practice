import java.io.*;
import java.util.*;

class Toh{
    public void moveToh(int n, String source, String buffer, String destination){
        if(n==1){
            System.out.println("Move Disk "+Integer.toString(n)+" from "+source+" to "+destination);
            return;
        }
        moveToh(n-1,source,destination,buffer);
        System.out.println("Move Disk "+Integer.toString(n)+" from "+source+" to "+destination);
        moveToh(n-1,buffer,source,destination);
    }
    public static void main(String args[]){
        Toh s = new Toh();
        s.moveToh(3,"A","B","C");
    }
}