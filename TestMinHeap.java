public class TestMinHeap{
	public static void main(String args[]){
		Node n = new Node("a", "b", 6);
		Node m = new Node("c", "d", 1);
		MinHeap h = new MinHeap(3);
		h.addElement(n);
		h.addElement(m);
		System.out.print(h.extractMin());
		//h.addElement(m);
	}
}