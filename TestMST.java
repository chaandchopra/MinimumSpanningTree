public class TestMST{
	public static void main(String args[]){
		Graph g = new Graph(2,3);
		Node s = new Node("1", "2", 5);
		g.addNode(s);
		MST m = new MST(g);
		System.out.println(m);
	}
}