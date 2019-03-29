public class MST{
	private Graph tree;
	private int edgeCount;
	private MinHeap minHeap = new MinHeap(no_of_edges);

	public MST(Graph g){
		edgeCount = 0;
		Graph t = new Graph(g.no_of_vertices, g.no_of_vertices - 1);
		tree = prims(g);
	}
	private Graph prims(Graph g){
		String[] mstNodes= new String[no_of_vertices];
		//adding 1st vertex of the list
		mstNodes[0] = g.vertex1[0];

		for(int i = 1; i <= edgeCount)
		return tree;
	}
	public String toString(){
		return tree.toString();
	}

}