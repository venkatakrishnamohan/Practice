import java.io.*;
import java.util.*;

class Solution_2_1{
    public void removeDups(LinkedList ll){
        Set<Integer> s = new HashSet<>();
        LLNode curr = ll.head;
        LLNode prev = null;
        while(curr != null){
            if(s.contains(curr.data)){
                prev.next = curr.next;
            }
            else{
                s.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }
    public LinkedList createLinkedList(int[] a){
        LinkedList ll = new LinkedList();
        for(int i=0;i<a.length;i++){
            ll.insert(a[i]);
        }
        return ll;
    }
    public void testDups(){
        int[] a = new int[] {1,2,2,1,2,3,4};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        removeDups(ll);
        List<Integer> l = ll.printData();
        int[] ans = new int[] {1,2,3,4};
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testNoDups(){
        int[] a = new int[] {1,2,3,4,5};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        removeDups(ll);
        List<Integer> l = ll.printData();
        int[] ans = new int[] {1,2,3,4,5};
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testOne(){
        int[] a = new int[] {1};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        removeDups(ll);
        List<Integer> l = ll.printData();
        int[] ans = new int[] {1};
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testEmpty(){
        int[] a = new int[] {};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        removeDups(ll);
        List<Integer> l = ll.printData();
        int[] ans = new int[] {};
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testAllSame(){
        int[] a = new int[] {1,1,1,1,1,1};
        LinkedList ll = createLinkedList(a);
        //ll.printData();
        removeDups(ll);
        List<Integer> l = ll.printData();
        int[] ans = new int[] {1};
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_2_1 s = new Solution_2_1();
        s.testDups();
        s.testNoDups();
        s.testAllSame();
        s.testEmpty();
        s.testOne();
    }
}