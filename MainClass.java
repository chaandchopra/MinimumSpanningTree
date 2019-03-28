
/**
 * Write a description of class MainClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
        String s = "./graph.txt";
        /**EdgeCollection g = new EdgeCollection(s);
        int [] di = g.GraphDimension();
        Node [] edges = g.EdgeArray();
        for(Node n: edges)
           System.out.println(n);**/
        Graph ga = new Graph(4, 2);
        //ga.CreateAdjacencyList();
        Node n1 = new Node("a","b", 1);
        Node n2 = new Node("c","d", 5); 
        ga.addNode(n1);
        ga.addNode(n2);
        //String b = null;
        System.out.println(ga);
       
    }
}
