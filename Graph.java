import java.util.*;
/**
 * Write a description of class Graph here.
 *
 * @author (17MCMC34,40)
 * @version (a vershttps://github.com/chaandchopra/MinimumSpanningTreeion number or a date)
 */
public class Graph
{
    // instance variables - replace the example below with your own
    public String [] vertices;//vertex
    public LinkedList<Node>[] connections;
    public int vertexCount;
    public int edgeCount;
    //EdgeCollection e;
    int [] graphDim;
    //Node [] connections;
    public Graph(int vertex, int edges)
    {
        vertices = new String[vertex];
        vertexCount = 0; 
        connections = new LinkedList[vertex];
        for(int i = 0; i < vertex; i++)
            connections[i] = new LinkedList<Node>();
        graphDim = new int[]{vertex, edges};
    }
    //to add a single edge
    public void addNode(Node n)
    {
        int loc = searchLoc(n.getVertex1());
        if(loc == -1)
        {
            vertices[vertexCount] = n.getVertex1();
            connections[vertexCount].add(n);
            vertexCount++;
        }
        else 
        {
            connections[loc].add(n);
        }
        loc = searchLoc(n.getVertex2());
        if(loc == -1)
        {
            vertices[vertexCount] = n.getVertex2();
            connections[vertexCount].add(n.reverseNode());
            vertexCount++;
        }
        else
        {
            connections[loc].add(n.reverseNode());
        }
        edgeCount++;
    }
    public LinkedList<Node> getEdgesOf(String vertex)
    {
        for(int i = 0; i < vertices.length; ++i)
        {
            if(vertices[i].equals(vertex))
            {
                return connections[i];
            }
        }
        return null;
    }
    private int searchLoc(String vertex)
    {
        //int exist = 0, loc = -1; 
        for(int i = 0; i < vertices.length; i++)
        {
            if(vertices[i] != null && vertices[i].equals(vertex))
            {
                return i;
            }
        }
        return -1;
    }
    private String PrintLinkedList(LinkedList <Node> conn)
    {
        String s = "";
        ListIterator<Node> i = conn.listIterator();
        while(i.hasNext())
        //for(Iterator i = conn.iterator(); i.hasNext();)
            s = s + i.next() + "  ";
        return s; 
    } 
    public String toString()
    {
        String s = "";
        for(int i = 0 ; i < graphDim[0]; ++i)
            s = s + "|" + vertices[i] + "|" + "->  " + PrintLinkedList(connections[i]) + "\n";
        s = s + "--------------------------------------------\n";
        return s; 
    }
	public Graph prims(){
		//init empty tree
		Graph mst = new Graph(this.vertexCount, this.vertexCount - 1);
		String[] mstNodes = new String[this.vertexCount];
		//initialising heap
		MinHeap minHeap = new MinHeap(2 * this.edgeCount);
		//adding 1st vertex of the list
		mstNodes[0] = this.vertices[0];
		int mstEdgeCount = 0;
		int mstVertexCount = 1;
		//add all edges of this vertex in min heap
		LinkedList<Node> l = this.getEdgesOf(this.vertices[0]);
		//System.out.print(l);
		ListIterator<Node> it = l.listIterator(0);
		while(it.hasNext()){
			minHeap.addElement(it.next());
		}
		Node tempNode;
		//System.out.println("minHeap "+minHeap);
		//System.out.println("mstEdgeCount " + mstEdgeCount);
		//System.out.println("vertexCount " + vertexCount);
		while(mstEdgeCount < this.vertexCount - 1){
			//total |v| - 1 edges in tree
			//add the min edge 
			tempNode = minHeap.extractMin();
			//cycle detection
			String v2 = tempNode.getVertex2();
			if(!foundIn(mstNodes, v2)){
				mst.addNode(tempNode);
				mstEdgeCount++;
				mstNodes[mstVertexCount++] = v2;
				//add all edges of v2
				l = this.getEdgesOf(v2);
				it = l.listIterator(0);
				while(it.hasNext()){
					minHeap.addElement(it.next());
				}
			}
		}
		return mst;
	}
	private boolean foundIn(String[] mstNodes, String key){
		for(int i = 0; i < mstNodes.length; i++){
			if(key.equals(mstNodes[i]))
				return true;
		}
		return false;
	}
}
class Node
{
    // instance variables - replace the example below with your own
    private int weight;
    private String vertex1;
    private String vertex2;
    /**
     * Constructor for objects of class Node
     */
    public Node()
    {
        // initialise instance variables
        this.weight = 0;
        this.vertex1 = "";
        this.vertex2 = "";
    }
    
    public Node(String v1, String v2, int w)
    {
        // initialise instance variables
        this.weight = w;
        this.vertex1 = v1;
        this.vertex2 = v2;
    }
    
    public Node reverseNode()
    {
        Node n = new Node(this.vertex2, this.vertex1, this.weight);
        return n;
    }
    
    public String toString()
    {
        return vertex1 + "-"+"(" + weight + ")"+"->" + vertex2 ;
    }
    /*get methods */
    public int getWeight()
    {
        return weight;
    }
    public String getVertex1()
    {
        return vertex1;
    }
    public String getVertex2()
    {
        return vertex2;
    }
}
