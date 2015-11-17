/**
 * Sort a linked list in O(n log n) time using constant space complexity. Time ~
 * O(NlogN), Space ~ O(1)
 * 
 * "merge sort"
 * 
 * @author cassie9082
 * 
 */

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		//find middle
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// merge two lists recursively
		ListNode left = head;
		ListNode right = slow.next;
		slow.next = null;// break into two lists

		left = sortList(left);
		right = sortList(right);
		return merge(left, right);
	}

	public ListNode merge(ListNode left, ListNode right) {
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		while (left != null && right != null) {
			if (left.val < right.val) {
				curr.next = left;
				left = left.next;
			} else {
				curr.next = right;
				right = right.next;
			}
			curr = curr.next;
		}

		if (left != null) {
			curr.next = left;
		}
		if (right != null) {
			curr.next = right;
		}
		return dummy.next;
	}
}
