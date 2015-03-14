/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 * @author cassie9082
 * 
 */
public class RemoveDuplicatesFromSortedListII {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while (head.next != null && head.next.next != null) {
			if (head.next.val == head.next.next.val) {
				int val = head.next.val;
				while (head.next != null && head.next.val == val) {
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII list = new RemoveDuplicatesFromSortedListII();
		ListNode n1 = list.new ListNode(1);
		ListNode n2 = list.new ListNode(1);
		ListNode n3 = list.new ListNode(2);
//		ListNode n4 = list.new ListNode(3);
//		ListNode n5 = list.new ListNode(4);
//		ListNode n6 = list.new ListNode(4);
		n1.next = n2;
		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
		n1 = list.deleteDuplicates(n1);
		printList(n1);
	}

	public static void printList(ListNode x) {
		if (x != null) {
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
	}
}
