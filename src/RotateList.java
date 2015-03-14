/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative. For example: Given 1->2->3->4->5->NULL and k = 2, return
 * 4->5->1->2->3->NULL.
 */
public class RotateList {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return head;
		}

		int length = getLength(head);
		n = n % length;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		//需要tail和head两个指针来确定要rotatelist的位置以及方便链接成一个新的list
		ListNode tail = head;
		for (int i = 0; i < n; i++) {
			head = head.next;
		}
		while (head.next != null) {
			head = head.next;
			tail = tail.next;
		}
		tail.next = dummy.next;//与九章给的答案有出入？？？？？
		dummy.next = head.next;
		head.next = null;//??????
		return dummy.next;

	}

	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}

}
