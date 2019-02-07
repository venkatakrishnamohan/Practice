import java.io.*;
import java.util.*;

class Solution_4_7{
    public List<String> buildOrder(List<String> projects, List<List<String>> deps){
        int[][] adjMat = buildGraph(projects, deps);
        List<String> res = new ArrayList<>();
        List<String> done = new ArrayList<>();
        String av = findAvailable(projects,adjMat,done);
        while(!av.equals("NA") && !checkAll(adjMat)){
        res.add(av);
        adjMat = modifyAdjMat(av, projects,adjMat);
        av = findAvailable(projects, adjMat,done);
        }
        if(checkAll(adjMat)){
            return new ArrayList<String>(done);
        }
        else{
            return null;
        }
    }
    public int[][] buildGraph(List<String> projects, List<List<String>> deps){
        int[][] adjMat = new int[projects.size()][projects.size()];
        for(int i=0;i<deps.size();i++){
                int iind = getIndex(projects, deps.get(i).get(0));
                int jind = getIndex(projects, deps.get(i).get(1));
                adjMat[jind][iind] = 1;
        }
        return adjMat;
    }
    public String findAvailable(List<String> projects, int[][] adjMat, List<String> done){
        for(int i=0;i<adjMat.length;i++){
            int c = 0;
            for(int j=0;j<adjMat[i].length;j++){
                if(adjMat[i][j] == 0){
                    c+=1;
                }
            }
            if(c == projects.size() && !done.contains(projects.get(i))){
                done.add(projects.get(i));
                return projects.get(i);
            }
        }
        return "NA";
    }
    public int getIndex(List<String> projects, String av){
        int ind = -1;
        for(int i=0;i<projects.size();i++){
            if(av.equals(projects.get(i))){
                ind = i;
                break;
            }
        }
        return ind;
    }
    public int[][] modifyAdjMat(String av, List<String> projects, int[][] adjMat){
        int ind = getIndex(projects,av);
        for(int i=0;i<adjMat[ind].length;i++){
            adjMat[i][ind] = 0;
        }
        return adjMat;
    }
    public boolean checkAll(int[][] adjMat){
        for(int i=0;i<adjMat.length;i++){
            for(int j=0;j<adjMat[i].length;j++){
                if(adjMat[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
    public void printProjects(List<String> res){
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
    public void test1(){
        List<String> projects = new ArrayList<>();
        projects.add("a");
        projects.add("b");
        projects.add("c");
        projects.add("d");
        projects.add("e");
        projects.add("f");
        List<List<String>> deps = new ArrayList<List<String>>();
        List<String> d1 = new ArrayList<>();
        d1.add("a");
        d1.add("d");
        List<String> d2 = new ArrayList<>();
        d2.add("f");
        d2.add("b");
        List<String> d3 = new ArrayList<>();
        d3.add("b");
        d3.add("d");
        List<String> d4 = new ArrayList<>();
        d4.add("f");
        d4.add("a");
        List<String> d5 = new ArrayList<>();
        d5.add("d");
        d5.add("c");
        deps.add(d1);
        deps.add(d2);
        deps.add(d3);
        deps.add(d4);
        deps.add(d5);
        List<String> res = buildOrder(projects,deps);
        if(res!= null){
            System.out.println("Testcase passed");
            printProjects(res);
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public void test2(){
        List<String> projects = new ArrayList<>();
        projects.add("a");
        projects.add("b");
        projects.add("c");
        projects.add("d");
        projects.add("e");
        projects.add("f");
        List<List<String>> deps = new ArrayList<List<String>>();
        List<String> d1 = new ArrayList<>();
        d1.add("a");
        d1.add("d");
        List<String> d2 = new ArrayList<>();
        d2.add("f");
        d2.add("b");
        List<String> d3 = new ArrayList<>();
        d3.add("b");
        d3.add("d");
        List<String> d4 = new ArrayList<>();
        d4.add("f");
        d4.add("a");
        List<String> d5 = new ArrayList<>();
        d5.add("d");
        d5.add("c");
        List<String> d6 = new ArrayList<>();
        d6.add("a");
        d6.add("f");
        List<String> d7 = new ArrayList<>();
        d7.add("a");
        d7.add("e");
        deps.add(d1);
        deps.add(d2);
        deps.add(d3);
        deps.add(d4);
        deps.add(d5);
        deps.add(d6);
        deps.add(d7);
        List<String> res = buildOrder(projects,deps);
        if(res== null){
            System.out.println("Testcase passed");
        }
        else{
            System.out.println("Testcase Failed");
        }
    }
    public static void main(String args[]){
        Solution_4_7 s = new Solution_4_7();
        s.test1();
        s.test2();
    }
}