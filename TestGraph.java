public class TestGraph{
	public static void main(String args[]){
		Graph g = new Graph(4,5);
		Node s1 = new Node("0", "1", 10);
		Node s2 = new Node("0", "2", 15);
		Node s3 = new Node("0", "3", 20);
		Node s4 = new Node("1", "2", 35);
		Node s5 = new Node("2", "3", 30);
		g.addNode(s1);
		g.addNode(s2);
		g.addNode(s3);
		g.addNode(s4);
		g.addNode(s5);
		
		System.out.println(g);
		Graph mst = g.prims();
		if(mst != null)
			System.out.println(mst);
	}
}
/**
 *4 5
0 1 10
0 2 15
0 3 20
1 2 35
2 3 30 
 */
