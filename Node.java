/**
 * Node class
 *
 * The Node class holds the priority of
 * the node with the constructor and
 * toString method.
 */
public class Node {

	// Node priority
	public int priority;

	/**
	 * Node constructor
	 */
	public Node(int priority) {
		this.priority = priority;
	}

	/**
	 * toString method that returns the 
	 * priority as a string
	 * @return String, string value of Node
	 */
	public String toString() {
		return "Priority: " + priority;
	}
}