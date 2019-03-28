import java.util.*;
import java.lang.*;
/**
 * Write a description of class Heap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heap
{
    // instance variables - replace the example below with your own
    private Node [] myHeap;

    /**
     * Constructor for objects of class Heap
     */
    public Heap(Node list[])
    {
        // initialise instance variables
        this.myHeap = new Node[list.length];
        this.myHeap = list;
    }
    
    public void Heapify(int i, int end)
    {
       int l = 2*i;
       int size = this.myHeap.length;
       int r = 2*i+1;
       int smallest = i;
       //System.out.println("smallest "+ smallest + " l " + l + " r "+ r );
       if(l < end && this.myHeap[l].getWeight() <= this.myHeap[i].getWeight())
        smallest = l;
       else
        smallest = i;
       if(r < end && this.myHeap[r].getWeight() <= this.myHeap[smallest].getWeight())
        smallest = r;
       //System.out.println("after comparing -smallest "+ smallest + " l " + l + " r "+ r );
       if(smallest != i)
       {
           Node temp = this.myHeap[i];
           this.myHeap[i] = this.myHeap[smallest];
           this.myHeap[smallest] = temp;
           Heapify(smallest, end);           
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
            Heapify(i,n);
        }
        
    }
    
    public void HeapSort()
    {
        BuildHeap();
        int n = this.myHeap.length, k =n;
        while(k >= 0)
        {
            Heapify(k, n);
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
