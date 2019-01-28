import java.io.*;
import java.util.*;

class Solution_2_3{
    public void DeleteNode(LLNode n){
        if(n.next == null){
            n=null;
        }
        else{
            n.data = n.next.data;
            LLNode temp = n.next;
            n.next = temp.next;
            temp.next = null;
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
        LLNode curr = ll.head;
        int count = 1;
        while(count<3){
            curr = curr.next;
            count+=1;
        }
        DeleteNode(curr);
        List<Integer> l = ll.printData();
        int[] ans = new int[] {1,2,1,2,3,4};
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void testTrue2(){
        int[] a = new int[] {1,2,2,1,2,3,4};
        LinkedList ll = createLinkedList(a);
        LLNode curr = ll.head;
        int count = 1;
        while(count<6){
            curr = curr.next;
            count+=1;
        }
        DeleteNode(curr);
        List<Integer> l = ll.printData();
        int[] ans = new int[] {1,2,2,1,2,4};
        if(Arrays.equals(ans,l.stream().mapToInt(Integer::intValue).toArray())){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_2_3 s = new Solution_2_3();
        s.testTrue();
        s.testTrue2();
    }
}