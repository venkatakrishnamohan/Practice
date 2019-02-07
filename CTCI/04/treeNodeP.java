import java.io.*;
import java.util.*;

class treeNodeP{
    int data;
    treeNodeP left;
    treeNodeP right;
    treeNodeP parent;
    public treeNodeP(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}