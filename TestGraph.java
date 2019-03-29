public class TestGraph{
	public static void main(String args[]){
		Graph g = new Graph(2,3);
		Node s = new Node("1", "2", 5);
		g.addNode(s);
		System.out.println(g);
		Graph mst = g.prims();
		if(mst != null)
			System.out.println(mst);
	}
}