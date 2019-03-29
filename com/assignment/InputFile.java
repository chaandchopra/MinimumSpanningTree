package com.assignment;
import java.io.*;
import java.util.*;
public class InputFile{
	public Graph getGraphFromFile(String fname)throws Exception{
        Graph g;
		BufferedReader br = new BufferedReader(new FileReader(fname));
	    String graphDim[] = br.readLine().split(" ");
	    int m = Integer.parseInt(graphDim[0]);//no of vertices
	    int n = Integer.parseInt(graphDim[1]);//no of edges
	            //System.out.printf("%d %d\n",m,n);
	    g = new Graph(m, n);
	    Node node;
	    String line;
	    while (n-- > 0) {
	    	//System.out.println(line);
	    	if((line = br.readLine()) != null){
		        String []edge = line.split(" ");
		        node = new Node(edge[0] , edge[1], Integer.parseInt(edge[2]));
		        //System.out.println(node);
		        g.addNode(node);
		    }
	    }
        return g;
	}
}
