/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author cassie9082
 * 
 */
public class ReorderList {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * 1. find middle 2. reverse 3. merge
	 * 
	 * @param head
	 */
	public void reorderList(ListNode head) {
		if(head == null || head.next == null){
			return;
		}
		ListNode mid = findMiddle(head);
		ListNode tail = reverse(mid.next);
		merge(head , tail);
	}

	public ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse(ListNode head) {
		ListNode newHead = null;// newHead是新的reverse的list的head
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;// *把要反转的数接到reverse的list当前元素的前面
			newHead = head;
			head = temp;// 把head移到temp处准备反转第二个数字
		}
		return newHead;
	}

	public void merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		int index = 0;
		while (head1 != null && head2 != null) {
			if (index % 2 == 0) {
				dummy.next = head1;
				head1 = head1.next;
			} else {
				dummy.next = head2;
				head2 = head2.next;
			}
			dummy = dummy.next;
			index++;
		}
		if (head1 != null) {
			dummy.next = head1;
		} else {
			dummy.next = head2;
		}
	}

}
