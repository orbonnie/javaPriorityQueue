public class Main {
  public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue();

		Node node1 = new Node("first", 1);
		Node node2 = new Node("next", 3);
		Node node3 = new Node("then", 5);
		Node node4 = new Node("low", 10);
		Node node5 = new Node("last", 15);

		queue.insertNode(node4);
		queue.insertNode(node2);
		queue.insertNode(node3);
		queue.insertNode(node5);
		queue.insertNode(node1);

		Node hp = queue.popMax();
		Node sp = queue.popMax();

		System.out.print("POPPED " + hp.value + " " + hp.priority + "\n");
		System.out.print("POPPED " + sp.value + " " + sp.priority + "\n");

		for(Node n: queue.values) {
			System.out.print(n.value + " " + n.priority + "\n");
		}

	}
}
