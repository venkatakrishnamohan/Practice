import java.io.*;
import java.util.*;

class Solution_3_6{
    Queue<Solution_3_6_Helper> cats;
    Queue<Solution_3_6_Helper> dogs;
    public Solution_3_6(){
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }
    public void enqueue(String name, String type){
        Solution_3_6_Helper s = new Solution_3_6_Helper(name, type);
        if(type == "dogs"){
            dogs.add(s);
        }
        else{
            cats.add(s);
        }
    }
    public Solution_3_6_Helper dequeueAny(){
        if(!dogs.isEmpty() && !cats.isEmpty() && dogs.peek().time < cats.peek().time){
            return dogs.remove();
        }
        else if(!dogs.isEmpty() && !cats.isEmpty() && dogs.peek().time >= cats.peek().time){
            return cats.remove();
        }
        else if(!dogs.isEmpty()){
            return dogs.remove();
        }
        else if(!cats.isEmpty()){
            return cats.remove();
        }
        else{
            return null;
        }
    }
    public Solution_3_6_Helper dequeueCats(){
        if(!cats.isEmpty()){
            return cats.remove();
        }
        else{
            return null;
        }
    }
    public Solution_3_6_Helper dequeueDogs(){
        if(!dogs.isEmpty()){
            return dogs.remove();
        }
        else{
            return null;
        }
    }
    public static void main(String args[]){
        Solution_3_6 s = new Solution_3_6();
        s.enqueue("d1","dogs");
        s.enqueue("c1","cats");
        s.enqueue("d2","dogs");
        s.enqueue("c2","cats");
        System.out.println(s.dequeueDogs().name);
        System.out.println(s.dequeueAny().name);
        System.out.println(s.dequeueCats().name);
        System.out.println(s.dequeueAny().name);
    }
}