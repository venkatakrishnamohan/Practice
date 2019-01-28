import java.io.*;
import java.util.*;

class Solution_2_2{
    public int KLast(LinkedList ll, int k){
        LLNode curr = ll.head;
        LLNode runner = ll.head;
        int count = 1;
        if(curr == null){
            return -1;
        }
        while(runner != null && count<k){
            runner = runner.next;
            count+=1;
        }
        if(runner == null){
            return -1;
        }
        else{
            while(runner.next != null){
                runner = runner.next;
                curr = curr.next;
            }
            return curr.data;
        }
    }
    public LinkedList createLinkedList(int[] a){
        LinkedList ll = new LinkedList();
        for(int i=0;i<a.length;i++){
            ll.insert(a[i]);
        }
        return ll;
    }
    public void testTrue(){
        int[] a = new int[] {1,2,2,1,2,3,4};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        int k = KLast(ll,2);
        if(k == 3){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testFalse(){
        int[] a = new int[] {1,2,2,1,2,3,4};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        int k = KLast(ll,10);
        if(k == -1){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        int[] a = new int[] {1};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        int k = KLast(ll,1);
        if(k == 1){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEmpty(){
        int[] a = new int[] {};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        int k = KLast(ll,1);
        if(k == -1){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testTrue2(){
        int[] a = new int[] {5,4,6,2,7,1};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        int k = KLast(ll,6);
        if(k == 5){
            System.out.println("Testcase Passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_2_2 s = new Solution_2_2();
        s.testEmpty();
        s.testFalse();
        s.testOne();
        s.testTrue();
        s.testTrue2();
    }
}