
/**
 * Write a description of class MainClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
public class MainClass
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        /**Node n = new Node("a","b", 10);
        System.out.println(n); //Node Class Implementation  
        
        Node n1 = new Node("a","b", 1);
        Node n2 = new Node("a","b", 5);
        Node [] heap = new Node[3];
        heap[0] = n;
        heap[1] = n1;
        heap[2] = n2;
        Heap h = new Heap(heap);
        h.HeapSort();
        System.out.println("HeapSOrt"+h);//Heap Class Implementation
        **/
        // String s = "graph.txt";
        /**EdgeCollection g = new EdgeCollection(s);
        int [] di = g.GraphDimension();
        Node [] edges = g.EdgeArray();
        for(Node n: edges)
           System.out.println(n);**/
        // Graph ga = new Graph(s);
        // ga.CreateAdjacencyList();
        
        //String b = null;
        // System.out.println(ga);
        String line;
        try {

        	BufferedReader br = new BufferedReader(new FileReader(args[0]));
         	String graphDim[] = br.readLine().split(" ");
         	int m = Integer.parseInt(graphDim[0]);
         	int n = Integer.parseInt(graphDim[1]);
         	System.out.printf("%d %d\n",m,n);

        	while ((line = br.readLine()) != null) {
            	//System.out.println(line);
            	String []edge = line.split(" ");
            	node = new Node(edge[0] , edge[1], Integer.parseInt(edge[2]));
            	System.out.println(node);
            	node = new Node(edge[1] , edge[0], Integer.parseInt(edge[2]));
            	System.out.println(node);
         	}       
      	} 
      	catch(Exception e) {
         	e.printStackTrace();
      	}
    }
}
