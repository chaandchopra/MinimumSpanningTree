/**
 * Write a description of class MainClass here.
 *
 * @author 17MCMC34,40
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class MainClass
{
    public static void main(String[] args){
        
        String line;
        try {

            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String graphDim[] = br.readLine().split(" ");
            int m = Integer.parseInt(graphDim[0]);
            int n = Integer.parseInt(graphDim[1]);
            System.out.printf("%d %d\n",m,n);
            Graph g = new Graph(m, n);
            Node node;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String []edge = line.split(" ");
                node = new Node(edge[0] , edge[1], Integer.parseInt(edge[2]));
                //System.out.println(node);
                g.addNode(node);
            }

            System.out.println(g);
            Graph mst = g.prims();
            if(mst != null)
                System.out.println(mst);       
            } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}