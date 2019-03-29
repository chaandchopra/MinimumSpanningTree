package com.assignment;
public class Node
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
