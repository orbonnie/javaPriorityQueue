public class Main {
  public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(3);

		Node node1 = new Node("first", 1);
		Node node2 = new Node("next", 3);
		Node node3 = new Node("then", 5);
		Node node4 = new Node("low", 10);
		Node node5 = new Node("last", 15);
		Node node6 = new Node("mid", 7);
		Node node7 = new Node("med",8);
		Node node8 = new Node("new",4);
		Node node9 = new Node("newer",11);
		Node node10 = new Node("newest",6);

		queue.insertNode(node4); //10
		queue.insertNode(node3); //5
		queue.insertNode(node9); //11
		queue.insertNode(node6); //7
		queue.insertNode(node8); //4
		queue.insertNode(node5); //15
		queue.insertNode(node7); //8
		queue.insertNode(node1); //1
		queue.insertNode(node10); //6
		queue.insertNode(node2); //3

		Node highest_p = queue.popMax();
		Node second_p = queue.popMax();
		Node third_p = queue.popMax();

		System.out.print("POPPED " + highest_p.value + " " + highest_p.priority + "\n");
		System.out.print("POPPED " + second_p.value + " " + second_p.priority + "\n");
		System.out.print("POPPED " + third_p.value + " " + third_p.priority + "\n");

		for(Node n: queue.values) {
			System.out.print(n.value + " " + n.priority + "\n");
		}

	}
}
