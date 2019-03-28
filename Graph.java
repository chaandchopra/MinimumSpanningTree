import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Write a description of class Graph here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
        graphDim = new int[2];
        graphDim = Arrays.copyOf(e.GraphDimension(), e.GraphDimension().length);
        Vertex1 = new String[graphDim[0]];
        for(String s : Vertex1)
        {
            s = null;
        }
        connections = new LinkedList[graphDim[0]];
        edges = new Node[graphDim[1]];
        edges = Arrays.copyOf(e.EdgeArray(), e.EdgeArray().length);
    }
    public void ImplementVertex1()
    {
        int exist = 0, notNullPtr = 0;
        for(int i = 0 ; i < graphDim[1]; i++)
        {
            String vertex = edges[i].getVertex1();
            exist = 0;
            for(String s: Vertex1)
            {
                if(s.equals(vertex))
                    exist = 1;
            }
            if(exist == 0)
            {
                Vertex1[notNullPtr] = vertex;
                notNullPtr++;
            }
        }
    }
    public void ImplementConnections()
    {
        for(int i = 0; i < graphDim[0]; ++i)
        {
            String currVertex = Vertex1[i];
            for(Node n : edges)
            {
                String nodeV1 = n.getVertex1();
                if(nodeV1.equals(currVertex))
                    connections[i].add(n);
            }
        }
    }
    public void CreateAdjacencyList()
    {
        ImplementVertex1();
        ImplementConnections();
    }
}
