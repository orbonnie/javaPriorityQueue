import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue {

	public static void main(String args[]) {
		System.out.println("Queue created");
	}

	public ArrayList <Node> values;

	public PriorityQueue () {
		this.values = new ArrayList<Node>();
	}

	public void insertNode (Node node) {
		this.values.add(node);

		int childIndex = this.values.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (this.values.get(parentIndex).priority > this.values.get(childIndex).priority) {
			Collections.swap(this.values, parentIndex, childIndex);
			childIndex = parentIndex;
			parentIndex =(childIndex - 1) / 2;
		}
	}

	public Node popMax() {
		Collections.swap(this.values, 0, this.values.size() - 1);

		Node maxNode = this.values.get(this.values.size() - 1);
		this.values.remove(this.values.size() - 1);

		int parentIndex = 0;

		int childIndex = this.getChild(this.values, parentIndex);

		while(childIndex >= 0 && (this.values.get(parentIndex).priority > this.values.get(childIndex).priority)) {
			Collections.swap(this.values, parentIndex, childIndex);

			parentIndex = childIndex;

			childIndex = this.getChild(this.values, parentIndex);

		}

		return maxNode;
	}

	public int getChild (ArrayList <Node> arr, int i ) {
		if (arr.size() > (i * 2 + 1)) {
			if (arr.size() <= (i * 2 + 2)) {
				return i * 2 + 1;
			}else if (arr.get(i * 2 + 1).priority < arr.get(i * 2 + 2).priority) {
				return i * 2 + 1;
			} else {
				return i * 2 + 2;
			}
		} else {
			return - 1;
		}
	}
}