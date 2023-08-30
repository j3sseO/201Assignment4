import java.util.Arrays;
/**
 * Priority class
 *
 * The PriorityQueue class holds an array of
 * Nodes, the pointer to the next index
 * to insert to in the array, and a set
 * of operations
 */
public class PriorityQueue {

	// Array of Nodes
	Node[] nodeArray;
	
	// Pointer to next index in Node array
	int next = 0;

	/**
	 * PriorityQueue constructor
	 */
	public PriorityQueue(int capacity) {
		nodeArray = new Node[capacity + 1];
		next = 1;
	}

	/**
	 * insert(Node n)
	 * Inserts Node into heap while maintaining
	 * priority order
	 * @param n, the Node to insert into priority queue (min heap)
	 */
	public void insert(Node n) {
		nodeArray[next] = n;
		upHeap(next);
		next++;
	}

	/**
	 * delete(Node n)
	 * Deletes the node from the front of the 
	 * queue (top of the heap)
	 * @return toReturn, the Node that is being deleted
	 */
	public Node delete() {
		int root = 1;
		int lastLeaf = next - 1;

		if (next == 1) {
			return null;
		}

		if (root == lastLeaf) {
			Node toReturn = nodeArray[lastLeaf];
			nodeArray[lastLeaf] = null;
			next--;
			return toReturn;
		}
		else {
			swap(root, lastLeaf);
			Node toReturn = nodeArray[lastLeaf];
			nodeArray[lastLeaf] = null;
			next--;
			downHeap();
			return toReturn;
		}
	}

	/**
	 * upHeap(int pos)
	 * Method that keeps heap ordered with lower values
	 * above higher values in the tree
	 * @param pos, position to up heap from
	 */
	private void upHeap(int pos) {
		int child = pos;

		while (child > 1) {
			int parent = child / 2;
			if (nodeArray[child].priority < nodeArray[parent].priority) {
				swap(child, parent);
			}
			child = parent;
		}
	}

	/**
	 * downHeap()
	 * Method that is called when a Node is 
	 * deleted from the heap. Higher values are moved down
	 * the tree
	 */
	private void downHeap() {
		int smallest = -1;
		int parent = 1;
		
		if (nodeArray[2] == null) {
			return;
		}

		while (parent < next) {
			int left = parent * 2;
			int right = (parent * 2) + 1;

			if (left < next && nodeArray[left].priority <= nodeArray[parent].priority) {
				smallest = left;
			}

			if (right < next && nodeArray[right].priority <= nodeArray[smallest].priority) {
				smallest = right;
			}

			if (parent != smallest) {
				swap(parent, smallest);
				parent = smallest;
			}
			else {
				break;
			}
		}
	}
	
	/**
	 * dump()
	 * Method to print the resultant heap tree
	 */
	public void dump() {
		for (int i = 1; i < nodeArray.length; i++) {
			System.out.print("Root: " + nodeArray[i] + "; ");

			if (i * 2 < nodeArray.length) {
				System.out.print("Left: " + nodeArray[i * 2] + "; ");
			}
			else {
				System.out.print("Left: null; ");
			}

			if ((i * 2) + 1 < nodeArray.length) {
				System.out.print("Right: " + nodeArray[(i * 2) + 1] + "; ");
			}
			else {
				System.out.print("Right: null; ");
			}
			System.out.println();
		}
	}

	/**
	 * swap(int pos1, int pos2)
	 * Method that swaps the Nodes at two
	 * positions of array
	 */
	private void swap(int pos1, int pos2) {
		Node temp = nodeArray[pos1];
		nodeArray[pos1] = nodeArray[pos2];
		nodeArray[pos2] = temp;
	}
}