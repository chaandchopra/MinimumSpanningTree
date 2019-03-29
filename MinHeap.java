import java.util.*;
import java.lang.*;
/**
 * Write a description of class Heap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MinHeap
{
    // instance variables - replace the example below with your own
    private Node [] myHeap;
    private int capacity;
    private int size;

    /**
     * Constructor for objects of class Heap
     */
    public MinHeap(int capacity)
    {
        this.myHeap = new Node[capacity];
        this.size = 0;
        this.capacity = capacity;
    }
    public MinHeap(Node list[])
    {
        // initialise instance variables
        this.myHeap = new Node[list.length];
        this.myHeap = list;
        this.capacity = list.length;
        this.size = list.length;
    }
    private int lchild(int i){
      return 2*i;
    }
    private int rchild(int i){
      return 2*i+1;
    }
    private int parent(int i){
      return i/2;
    }

    public void Heapify(int i)
    {
       int l = lchild(i);
       //int size = this.myHeap.length;
       int r = rchild(i);
       int smallest = i;
       //System.out.println("smallest "+ smallest + " l " + l + " r "+ r );
       if(l < size && this.myHeap[l].getWeight() <= this.myHeap[i].getWeight())
        smallest = l;
       else
        smallest = i;
       if(r < size && this.myHeap[r].getWeight() <= this.myHeap[smallest].getWeight())
        smallest = r;
       //System.out.println("after comparing -smallest "+ smallest + " l " + l + " r "+ r );
       if(smallest != i)
       {
           Node temp = this.myHeap[i];
           this.myHeap[i] = this.myHeap[smallest];
           this.myHeap[smallest] = temp;
           Heapify(smallest);           
       }
    }
    
    public void BuildHeap()
    {
        int n = this.myHeap.length;
        int value = (int)Math.floor(n/2)-1;
        for(int i = value; i >= 0; --i)
        {
            Heapify(i);
        }
        
    }
    
    public Node extractMin()
    {   
        //System.out.println("emin size " + size);
        if(this.size == 0){
            System.out.println("Heap Underflow");
            return null;
        }
        Node r = myHeap[0];
        myHeap[0] = myHeap[this.size - 1];
        myHeap[this.size - 1] = r;
        this.size--;
        Heapify(0);            
        return r;
    }
    
    public void addElement(Node n)
    {
        //System.out.println
        if(this.size == this.capacity)
        {
            System.out.println("Overflow");
            return;
        }
        myHeap[this.size] = n; 
        int current = this.size; 
        this.size++;
        //System.out.println("MinHeap size "+this.size);
        while (myHeap[current].getWeight() < myHeap[parent(current)].getWeight()) { 
            //swap(current, parent(current)); 
            Node temp = myHeap[current];
            myHeap[current] = myHeap[parent(current)];
            myHeap[parent(current)] = temp;
            current = parent(current); 
        } 
    }
    
    public void HeapSort()
    {
        BuildHeap();
        int n = this.myHeap.length, k = n;
        while(k >= 0)
        {
            Heapify(k);
            k--;
        }
    }
    
    public String toString()
    {
        String s = "";
        for(Node n : myHeap)
        {
            s = s + n + "   ";
        }
        return s;
    }
}
