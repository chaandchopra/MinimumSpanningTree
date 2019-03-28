
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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

    public String toString()
    {
        return vertex1 + "-->" + vertex2 + "(" + weight + ")";
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
