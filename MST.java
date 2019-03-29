import java.util.*;
public class MST{
	private Graph tree;

	public MST(Graph g){
		tree = prims(g);
	}
	private Graph prims(Graph g){
		//init empty tree
		Graph mst = new Graph(g.vertexCount, g.vertexCount - 1);
		String[] mstNodes = new String[g.vertexCount];
		//initialising heap
		MinHeap minHeap = new MinHeap(g.vertexCount - 1);
		//adding 1st vertex of the list
		mstNodes[0] = g.vertex1[0];
		int mstEdgeCount = 0;
		int mstVertexCount = 1;
		//add all edges of this vertex in min heap
		LinkedList<Node> l = g.getEdgesof(g.vertex1[0]);
		ListIterator<Node> it = l.listIterator(0);
		while(it.hasNext()){
			minHeap.addElement(it.next());
		}
		while(mstEdgeCount < g.vertexCount - 1)//total |v| - 1 edges in tree
			//add the min edge 
			Node tempNode = minHeap.extractMin();
			//cycle detection
			String v2 = tempNode.getVertex2();
			if(!foundIn(mstNodes, v2)){
				mst.addElement(tempNode);
			}
		}
		return tree;
	}
	public String toString(){
		return tree.toString();
	}

}