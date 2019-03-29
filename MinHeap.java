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
        this.size = list.length;
    }
    
    public void Heapify(int i)
    {
       int l = 2*i;
       //int size = this.myHeap.length;
       int r = 2*i+1;
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
       /*
       if(l < end && r < end){
           if(this.myHeap[l].getWeight() <= this.myHeap[r].getWeight())
            smallest = l;
           else
            smallest = r;
           if(this.myHeap[i].getWeight() <= this.myHeap[smallest].getWeight())
            return;
           if(smallest < end)
           {
               Node temp = this.myHeap[i];
               this.myHeap[i] = this.myHeap[smallest];
               this.myHeap[smallest] = temp;
               Heapify(smallest, end);
           } 
        }  */ 
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
        Node r = null;
        if(this.size == 1)
        {
            this.size--;
            r = myHeap[0];
        }
        if(this.size > 1)
        {
            r = myHeap[0];
            myHeap[0] = myHeap[this.size - 1];
            myHeap[this.size - 1] = r;
            Heapify(0);            
        }
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
        this.size++;
        int j = this.size - 1;
        //while(j != 0 && myHeap[(j-1)/2] > myHeap[i])
        Heapify(0);
    }
    
    public void HeapSort()
    {
        BuildHeap();
        int n = this.myHeap.length, k =n;
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
