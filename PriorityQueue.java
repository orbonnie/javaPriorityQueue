import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueue {

	public static void main(String args[]) {
		System.out.println("Queue created");
	}

	public ArrayList <Node> values;
	double x;

	public PriorityQueue (double x) {
		this.values = new ArrayList<Node>();
		this.x = x;
	}

	public void insertNode (Node node) {
		this.values.add(node);

		int childIndex = this.values.size() - 1;
		int divisor = (int)Math.pow(2, this.x);
		int parentIndex = childIndex / divisor;

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

		int divisor = (int)Math.pow(2, this.x);
		int parentIndex = 0;
		int childIndex = this.getChildren(this.values, parentIndex, divisor);

		while(childIndex >= 0 && (this.values.get(parentIndex).priority > this.values.get(childIndex).priority)) {
			Collections.swap(this.values, parentIndex, childIndex);

			parentIndex = childIndex;
			childIndex = this.getChildren(this.values, parentIndex, divisor);
		}

		return maxNode;
	}

	public int getChild (ArrayList <Node> arr, int i) {
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

	public int getChildren (ArrayList <Node> arr, int p, int div) {
		if ((arr.size() - 2)/ div >= p) {
			int topPriority = arr.get((p * div) + 1).priority;
			int priorityInd = (p * div) + 1;
			int end = Math.min((p + 1) * div, arr.size() - 1);

			for (int i = (p * div) + 2; i <= end; i ++) {
				int currPriority = arr.get(i).priority;
				if ( currPriority < topPriority) {
					topPriority = currPriority;
					priorityInd = i;
				}
			}
			return priorityInd;
		} else {
			return - 1;
		}
	}
}