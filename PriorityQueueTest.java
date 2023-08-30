import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class PriorityQueueTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setOut() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	@DisplayName("Insert test with empty queue, expected true")
	public void insertTestEmptyQueue() {
		PriorityQueue queue = new PriorityQueue(1);
		Node node = new Node(1);
		queue.insert(node);
		queue.dump();
	 	String actual = outputStreamCaptor.toString().trim();
		Assertions.assertEquals(actual, "Root: Priority: 1; Left: null; Right: null;");
	}

	@Test
	@DisplayName("Insert test with higher priority node last, depends on upheap(), expected true")
	public void insertTestWithHigherPriorityLast() {
		PriorityQueue queue = new PriorityQueue(2);
		queue.insert(new Node(2));
		queue.insert(new Node(1));
		queue.dump();
	 	String actual = outputStreamCaptor.toString().trim();
		Assertions.assertEquals(actual, "Root: Priority: 1; Left: Priority: 2; Right: null; "
								+ System.lineSeparator() + "Root: Priority: 2; Left: null; Right: null;");
	}

	@Test
	@DisplayName("Delete test with one node, expected true")
	public void deleteTestWithOneNode() {
		PriorityQueue queue = new PriorityQueue(1);
		queue.insert(new Node(1));
		queue.delete();
		queue.dump();
	 	String actual = outputStreamCaptor.toString().trim();
		Assertions.assertEquals(actual, "Root: null; Left: null; Right: null;");
	}

	@Test
	@DisplayName("Delete test with more nodes, expected true")
	public void deleteTestWithMoreNodes() {
		PriorityQueue queue = new PriorityQueue(3);
		queue.insert(new Node(1));
		queue.insert(new Node(2));
		queue.insert(new Node(3));
		queue.delete();
		queue.dump();
	 	String actual = outputStreamCaptor.toString().trim();
		Assertions.assertEquals(actual, "Root: Priority: 2; Left: Priority: 3; Right: null; " + System.lineSeparator()
								+ "Root: Priority: 3; Left: null; Right: null; " + System.lineSeparator()
								+ "Root: null; Left: null; Right: null;");
	}

	@Test
	@DisplayName("Dump test with empty queue, expected true")
	public void dumpTestWithEmptyQueue() {
		PriorityQueue queue = new PriorityQueue(0);
		queue.dump();
	 	String actual = outputStreamCaptor.toString().trim();
		Assertions.assertEquals(actual, "");
	}

	@Test
	@DisplayName("Dump test with one nodes, expected true")
	public void dumpTestWithOneNode() {
		PriorityQueue queue = new PriorityQueue(1);
		queue.insert(new Node(1));
		queue.dump();
	 	String actual = outputStreamCaptor.toString().trim();
		Assertions.assertEquals(actual, "Root: Priority: 1; Left: null; Right: null;");
	}
}