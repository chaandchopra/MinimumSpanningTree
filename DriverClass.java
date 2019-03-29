/**
 * Test class
 *
 * @author 17MCMC34,40
 * @version (a version number or a date)
 */
import java.io.*;
import com.assignment.Graph;
import com.assignment.InputFile;

public class DriverClass
{
    public static void main(String[] args){
        try{
            InputFile f = new InputFile();
            Graph g = f.getGraphFromFile(args[0]);
			System.out.println("\nInput Graph : ");
            System.out.println(g);
            System.out.println("Total weight of graph: "+ g.totalWeight);
            Graph mst = g.prims();	
			System.out.println("\nCorresponding MST : ");
            System.out.println(mst);    
            System.out.println("Total weight of mst: "+ mst.totalWeight);
        }
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Please enter a valid input file as command line argument");		
		}
        catch(NegativeArraySizeException e){
            System.out.println("Graph creation error. Provide valid graph file"); 
        }
        catch(FileNotFoundException e){
            System.out.println("File not found. Please check the input file name & path"); 
        }
        catch(Exception e) {
            System.out.println(e);	
        }
    }
}
