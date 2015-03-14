/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author cassie9082
 * 
 */
public class RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode node = head;
		while (node.next != null) {
			if (node.val == node.next.val) {
				node.next = node.next.next;// 当node指针移动到倒数第二位，若最后一位数和倒数第二位是相等到，此时node.next
											// = null
			} else {
				node = node.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList list = new RemoveDuplicatesFromSortedList();
		ListNode n1 = list.new ListNode(1);
		ListNode n2 = list.new ListNode(1);
		ListNode n3 = list.new ListNode(1);
		ListNode n4 = list.new ListNode(3);
		ListNode n5 = list.new ListNode(4);
		ListNode n6 = list.new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
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
