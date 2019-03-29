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
		mstNodes[0] = g.vertices[0];
		int mstEdgeCount = 0;
		int mstVertexCount = 1;
		//add all edges of this vertex in min heap
		String v = g.vertices[0];
		LinkedList<Node> l = g.getEdgesof(v);
		ListIterator<Node> it = l.listIterator(0);
		while(it.hasNext()){
			minHeap.addElement(it.next());
		}
		Node tempNode;
		while(mstEdgeCount < g.vertexCount - 1){//total |v| - 1 edges in tree
			//add the min edge 
			tempNode = minHeap.extractMin();
			//cycle detection
			String v2 = tempNode.getVertex2();
			if(!foundIn(mstNodes, v2)){
				mst.addNode(tempNode);
				mstEdgeCount++;
				mstNodes[mstVertexCount++] = v2;
			}
		}
		return mst;
	}
	private boolean foundIn(String[] mstNodes, String key){
		for(int i = 0; i < mstNodes.length; i++){
			if(key.equals(mstNodes[i]))
				return false;
		}
		return true;
	}
	public String toString(){
		return tree.toString();
	}

}