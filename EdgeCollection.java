/**
 * Write a description of class EdgeCollection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class EdgeCollection
{
    private String loc;

    /**
     * Constructor for objects of class Graph
     */
    public EdgeCollection(String location)
    {
        // initialise instance variables
        this.loc = location;
    }
    public int [] GraphDimension()/*returns vertex and edges count : [vertex, edges]*/
    {
        int dim[] = new int[2];
        try
        {
            BufferedReader read = new BufferedReader(new FileReader(loc));
            String line = read.readLine();
            String temp = "";
            char [] chars = line.toCharArray();
            for(char ch: chars)
            {
                if(ch != ' ')
                {
                    temp = temp + ch;
                }
                if(ch == ' ')
                {
                    if(temp != null)
                    {
                        dim[0] = Integer.parseInt(temp);
                    }                    
                }
            }
            dim[1] = Integer.parseInt(temp);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return dim;
    }

    public Node[] EdgeArray()/*returns Node array with all edges in [v1-v2-w] form*/
    {
        BufferedReader read;
        int [] dim = new int[2];
        dim = GraphDimension();
        Node [] edges = new Node[dim[0]];
        try
        {
            read = new BufferedReader(new FileReader(loc));
            String line = read.readLine();
            String v1= "", v2= "", temp = "";
            int weigh, spaceCount, lineCount = 0, edgeCount = 0;
            while(line != null)
            {
                if(lineCount > 0)
                {
                    temp = "";
                    spaceCount = 0;
                    char [] chars = line.toCharArray();
                    for(char ch: chars )
                    {
                        if(ch != ' ')
                        {
                            temp = temp + ch;
                        }
                        else{
                            if(spaceCount == 0)
                                v1 = temp;
                            else if(spaceCount == 1)
                                v2 = temp;
                            if(spaceCount == 2){
                                weigh = Integer.parseInt(temp);
                                Node e = new Node(v1, v2, weigh);
                                edges[edgeCount] = e;
                                edgeCount++;
                                break;
                            }
                        }
                        spaceCount++;
                    }
                }
                else
                {
                    lineCount++;
                }
            }   
        }catch(IOException e){
            e.printStackTrace();
        }
        return edges;
    }
}
