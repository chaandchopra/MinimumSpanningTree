import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Write a description of class Graph here.
 *
 * @author (your name)
 * @version (a vershttps://github.com/chaandchopra/MinimumSpanningTreeion number or a date)
 */
public class Graph
{
    // instance variables - replace the example below with your own
    String [] Vertex1;
    LinkedList<Node>[] connections;
    EdgeCollection e;
    int [] graphDim;
    Node [] edges;
    
    public Graph(String fileLoc)
    {
        e = new EdgeCollection(fileLoc);
        graphDim = e.GraphDimension();       
        edges = e.EdgeArray();
        connections = new LinkedList[graphDim[0]];
        for(int i = 0; i < graphDim[0]; i++)
            connections[i] = new LinkedList();
        Vertex1 = new String[graphDim[0]];
    }
    public void ImplementVertex1()
    {
        int exist = 0, notNullPtr = 0;
        for(int i = 0 ; i < graphDim[1]; i++)
        {
            String vertex1 = edges[i].getVertex1();
            String vertex2 = edges[i].getVertex2();
            exist = 0;
            for(String s: Vertex1)
            {
                if(s != null && s.equals(vertex1))
                {
                    exist = 1;
                    break;
                }
            }
            if(exist == 0)
            {
                Vertex1[notNullPtr] = vertex1;
                notNullPtr++;
            }

            exist = 0;
            for(String s: Vertex1)
            {
                if(s != null && s.equals(vertex2))
                {
                    exist = 1;
                    break;
                }
            }
            if(exist == 0)
            {
                Vertex1[notNullPtr] = vertex2;
                notNullPtr++;
            }            
        }
    }
    public void ImplementConnections()
    {
        System.out.println(connections.length);
        for(int i = 0; i < graphDim[0]; ++i)
        {
            String currVertex = Vertex1[i];
            for(Node n : edges)
            {
                String nodeV1 = n.getVertex1();
                if(nodeV1.equals(currVertex))
                {
                   connections[i].add(n);
                }
            }
        }
    }
    public void CreateAdjacencyList()
    {
        ImplementVertex1();
        ImplementConnections();
    }
    public String PrintLinkedList(LinkedList <Node> conn)
    {
        String s = "";
        for(Iterator i = conn.iterator(); i.hasNext();)
            s = s + i.next() + "  ";
        return s; 
    } 
    public String toString()
    {
        String s = "";
        for(int i = 0 ; i < graphDim[0]; ++i)
            s = s + Vertex1[i] + "----->" + PrintLinkedList(connections[i]) + "\n";
        return s; 
    }
    public void PrimsAlgorithm()
    {
       // 
    }
}
