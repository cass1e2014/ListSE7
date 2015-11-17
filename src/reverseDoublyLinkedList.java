/**
 * Reverse The Dou­bly Linked List.
 * 
 * @author cassie9082
 * 
 */
public class reverseDoublyLinkedList {
	public Node reverseDLL(Node head) {
		Node current = head;
		Node tmp = null;
		while (current != null) {
			tmp = current.prev;
			current.prev = current.next;
			current.next = tmp;
			current = current.prev;
		}
		return tmp.prev;
	}

	class Node {
		int val;
		Node prev;
		Node next;

		public Node(int val) {
			this.val = val;
			this.prev = null;
			this.next = null;
		}
	}
}
