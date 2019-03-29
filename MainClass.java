
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
        **/
        /**Node n = new Node("a","b", 10);
        Node n1 = new Node("a","b", 1);
        Node n2 = new Node("a","b", 5);
        Node [] heap = new Node[3];
        heap[0] = n;
        heap[1] = n1;
        heap[2] = n2;
        MinHeap h = new MinHeap(3);
        h.HeapSort();
        h.AddElement(heap[0]);
        h.AddElement(heap[1]);
        h.AddElement(heap[2]);
        Node ex = h.ExtractMin();
        System.out.println(ex);//Heap Class Implementation**/
        
        
        /**EdgeCollection g = new EdgeCollection(s);
        int [] di = g.GraphDimension();
        Node [] edges = g.EdgeArray();
        for(Node n: edges)
           System.out.println(n);**/
        String s = "graph.txt";   
        Node n = new Node("a","b", 10);
        Node n1 = new Node("c","d", 1);
        Node n2 = new Node("a","b", 5);        
        Graph ga = new Graph(4, 2);
        // ga.CreateAdjacencyList();
        ga.addNode(n);
        ga.addNode(n1);
        ga.addNode(n2);
        //String b = null;
        System.out.println(ga);
        /**String line;
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
        }**/
    }
}
