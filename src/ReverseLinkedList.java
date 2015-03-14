/*
 * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 * 在原地一次翻转完成
 */
public class ReverseLinkedList {
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}
}
